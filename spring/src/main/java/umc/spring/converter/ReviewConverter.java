package umc.spring.converter;

import umc.spring.domain.Review;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;

import java.time.LocalDateTime;

public class ReviewConverter {

    public static ReviewResponseDTO.JoinReviewResultDTO tojoinResultDTO(Review review) {
        return ReviewResponseDTO.JoinReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();

    }

    public static Review toReview(ReviewRequestDTO.JoinReviewDto request) {

        return Review.builder()
                .body(request.getBody())
                .title(request.getTitle())
                .score(request.getScore())
                .build();
    }

}
