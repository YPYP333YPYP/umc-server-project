package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import lombok.NoArgsConstructor;
import umc.spring.validation.annotation.ExistStore;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

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


