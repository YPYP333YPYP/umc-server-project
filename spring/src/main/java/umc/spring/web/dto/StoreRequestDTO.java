package umc.spring.web.dto;

import lombok.Getter;
import umc.spring.domain.Region;
import umc.spring.validation.annotation.ExistRegion;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class StoreRequestDTO {

    @Getter
    public static class AddStoreDTO {
        @NotBlank
        private String name;

        @NotBlank
        private String address;

        private Float score;

        @ExistRegion
        private String regionName;
    }
}
