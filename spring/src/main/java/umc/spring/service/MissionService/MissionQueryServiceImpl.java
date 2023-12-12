package umc.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.repository.MissionRepository;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class MissionQueryServiceImpl {

    private final MissionRepository missionRepository;
    public Optional<Mission> findMission(Long id) {
        return missionRepository.findById(id);
    }
}
