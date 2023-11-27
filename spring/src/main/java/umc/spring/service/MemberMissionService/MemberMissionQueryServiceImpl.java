package umc.spring.service.MemberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository;

@Service
@RequiredArgsConstructor
public class MemberMissionQueryServiceImpl implements MemberMissionQueryService {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public String getStatus(Long id) {
        MemberMission memberMission = memberMissionRepository.findStatusById(id);
        return memberMission.getStatus().name();
    }

}
