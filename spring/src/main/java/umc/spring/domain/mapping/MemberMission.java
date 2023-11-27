package umc.spring.domain.mapping;
import umc.spring.domain.FoodCategory;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.common.BaseEntity;
import lombok.*;
import umc.spring.domain.enums.MissionStatus;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 15, columnDefinition = "VARCHAR(15)")
    private MissionStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id" ,columnDefinition = "BIGINT")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id" ,columnDefinition = "BIGINT")
    private Mission mission;

    public void setStatus(MissionStatus missionStatus) {
        this.status = missionStatus;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public void setMission(Mission mission) {
        this.mission = mission;
    }
}