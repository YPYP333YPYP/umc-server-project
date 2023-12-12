package umc.spring.service.MissionService;

import umc.spring.domain.Member;

import java.util.Optional;

public interface MissionQueryService {

    Optional<Member> findMember(Long id);
}
