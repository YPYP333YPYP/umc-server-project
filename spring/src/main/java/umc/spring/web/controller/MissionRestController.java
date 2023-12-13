package umc.spring.web.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.MemberMissionService.MemberMissionCommandService;
import umc.spring.service.MissionService.MissionCommandService;
import umc.spring.web.dto.MemberMissionRequestDTO;
import umc.spring.web.dto.MemberMissionResponseDTO;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;


import javax.validation.Valid;
import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/mission")
public class MissionRestController {

    private final MissionCommandService missionCommandService;
    private final MemberMissionCommandService memberMissionCommandService;

    @PostMapping("/")
    public ApiResponse<MissionResponseDTO.JoinMissionResultDTO> join(@RequestBody @Valid MissionRequestDTO.JoinMissionDto request){
        Mission mission = missionCommandService.joinMission(request);
        return ApiResponse.onSuccess(MissionConverter.tojoinResultDTO(mission));
    }

    @PostMapping("/member")
    public ApiResponse<MemberMissionResponseDTO.JoinMemberMissionResultDTO> challenge(@RequestBody @Valid MemberMissionRequestDTO.JoinMemberMissionDto request) {
        MemberMission memberMission = memberMissionCommandService.joinMemberMission(request);
        return ApiResponse.onSuccess(MemberMissionConverter.joinMemberMissionResultDTO(memberMission));
    }



    @PatchMapping("/challenge")
    public ApiResponse<MemberMissionResponseDTO.JoinMemberMissionResultDTO> updateStatus(
            @RequestBody @Valid MemberMissionRequestDTO.UpdateStatusMemberMissionDto request) {
        Long updatedMemberMissionId = memberMissionCommandService.updateStatusToChallenging(request.getMemberMissionId());

        MemberMissionResponseDTO.JoinMemberMissionResultDTO memberMission =
                MemberMissionResponseDTO.JoinMemberMissionResultDTO.builder()
                        .memberMissionId(updatedMemberMissionId)
                        .createdAt(LocalDateTime.now())
                        .build();

        return ApiResponse.onSuccess(memberMission);
    }
}
