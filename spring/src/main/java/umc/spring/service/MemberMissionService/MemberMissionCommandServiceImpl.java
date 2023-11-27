package umc.spring.service.MemberMissionService;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.MemberHandler;
import umc.spring.apiPayload.exception.handler.MissionHandler;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.web.dto.MemberMissionRequestDTO;

import java.util.Optional;

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



}
