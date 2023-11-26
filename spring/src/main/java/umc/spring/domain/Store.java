package umc.spring.domain;

import lombok.*;
import umc.spring.domain.common.BaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Store extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT")
    private Long id;

    @Column(columnDefinition = "VARCHAR(50)")
    private String name;

    @Column(columnDefinition = "VARCHAR(50)")
    private String address;

    @Column(columnDefinition = "FLOAT")
    private Float score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id", columnDefinition = "BIGINT")
    private Region region;

    public void setRegion(Region region) {
        this.region = region;
    }

}