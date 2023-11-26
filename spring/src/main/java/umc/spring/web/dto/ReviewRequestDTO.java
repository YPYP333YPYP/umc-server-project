package umc.spring.web.dto;

import lombok.Getter;

import umc.spring.validation.annotation.ExistStore;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ReviewRequestDTO {

    @Getter
    public static class JoinReviewDto {

        @NotBlank
        String body;

        @NotNull
        String title;

        Float score;

        @NotNull
        Long memberId;
        @ExistStore
        Long storeId;
    }
}
