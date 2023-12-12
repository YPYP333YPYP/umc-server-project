package umc.spring.service.MemberMissionService;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.MemberHandler;
import umc.spring.apiPayload.exception.handler.MissionHandler;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.web.dto.MemberMissionRequestDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberMissionCommandServiceImpl implements  MemberMissionCommandService{

    private final MemberMissionRepository memberMissionRepository;
    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;

    @Override
    public MemberMission joinMemberMission(MemberMissionRequestDTO.JoinMemberMissionDto request) {

        MemberMission mm;

        Member member = memberRepository.findById(request.getMemberId()).orElseThrow(()-> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Mission mission = missionRepository.findById(request.getMissionId()).orElseThrow(()-> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));

        MissionStatus missionStatus = convertToMissionStatus(request.getStatus()).orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_STATUS_NOT_FOUND));


        mm = MemberMissionConverter.toMemberMission(request);
        mm.setStatus(missionStatus);
        mm.setMember(member);
        mm.setMission(mission);
        return memberMissionRepository.save(mm);
    }

    @Override
    public Long updateStatusToChallenging(Long memberMissionId) {
        MemberMission memberMission = memberMissionRepository.findById(memberMissionId)
                .orElseThrow(() -> new MissionHandler(ErrorStatus.MEMBER_MISSION_NOT_FOUND));


        memberMission.setStatus(MissionStatus.CHALLENGING);

        return memberMissionRepository.save(memberMission).getId();
    }

    private Optional<MissionStatus> convertToMissionStatus(String status) {
            return Optional.of(MissionStatus.valueOf(status.toUpperCase()));

    }

    public Page<Mission> getChallengingMissionList (Long memberId, Integer page) {

        List<MemberMission> challengingMemberMissions = memberMissionRepository
                .findAllByMemberIdAndStatus(memberId, MissionStatus.valueOf("CHALLENGING"));


        List<Mission> challengingMissions = challengingMemberMissions.stream()
                .map(MemberMission::getMission)
                .toList();

        int pageSize = 10;
        int totalElements = challengingMissions.size();

        List<Mission> pageContent = challengingMissions.stream()
                .skip(page * pageSize)
                .limit(pageSize)
                .collect(Collectors.toList());


        PageRequest pageRequest = PageRequest.of(page, pageSize);
        return new PageImpl<>(pageContent, pageRequest, totalElements);
    }



}
