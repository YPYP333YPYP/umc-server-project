package umc.spring.domain;

import lombok.*;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.enums.NotificationStatus;
import umc.spring.domain.enums.NotificationType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Notification  extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT")
    private Long id;

    @Column(length = 50, columnDefinition = "VARCHAR(50)")
    private String detail;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, columnDefinition = "VARCHAR(20)")
    private NotificationType notificationType;

    @Enumerated(EnumType.STRING)
    @Column(length = 30, columnDefinition = "VARCHAR(30) DEFAULT 'ON'")
    private NotificationStatus notificationStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", columnDefinition = "BIGINT")
    private Member member;


}
