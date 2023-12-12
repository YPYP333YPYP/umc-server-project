package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;

import java.util.List;
import java.util.Optional;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {

    MemberMission findStatusById(Long id);
    Optional<MemberMission> findByMemberAndMission(Member member, Mission mission);


    List<MemberMission>  findAllByMemberIdAndStatus(Long member_id, MissionStatus status);
}
