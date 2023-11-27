package umc.spring.web.dto;

import lombok.Getter;
import umc.spring.validation.annotation.ExistCategories;
import umc.spring.validation.annotation.IsChallenging;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class MemberMissionRequestDTO {

    @Getter
    public static class JoinMemberMissionDto{

        @NotNull
        String status;

        @NotNull
        Long memberId;

        @NotNull
        Long missionId;
    }

    @Getter
    public static class UpdateStatusMemberMissionDto {

        @IsChallenging
        @NotBlank
        Long memberMissionId;
    }
}
