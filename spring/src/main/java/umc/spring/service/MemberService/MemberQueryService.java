package umc.spring.service.MemberService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Store;

import java.util.Optional;

public interface MemberQueryService {

    Optional<Member> findMember(Long id);

    Page<Review> getReviewList(Long memberId, Integer page);



}
