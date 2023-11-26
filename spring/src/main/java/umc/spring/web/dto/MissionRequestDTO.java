package umc.spring.web.dto;

import lombok.Getter;
import umc.spring.validation.annotation.ExistCategories;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


public class MissionRequestDTO {
    @Getter
    public static class JoinMissionDto {

        @NotNull
        Integer reward;

        @NotNull
        LocalDate deadline;
        @NotBlank
        String missionSpec;

        @NotNull
        Long storeId;
    }
}

