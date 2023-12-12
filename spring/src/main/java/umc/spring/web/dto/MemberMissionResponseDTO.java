package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.Mission;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class MemberMissionResponseDTO {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class JoinMemberMissionResultDTO{
        Long memberMissionId;
        LocalDateTime createdAt;
    }




}
