package umc.spring.service.MemberMissionService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberMissionRequestDTO;
import umc.spring.web.dto.MemberRequestDTO;

public interface MemberMissionCommandService {
    MemberMission joinMemberMission(MemberMissionRequestDTO.JoinMemberMissionDto request);

    Long updateStatusToChallenging(Long memberMissionId);
    Page<Mission> getChallengingMissionList (Long memberId, Integer page);
}
