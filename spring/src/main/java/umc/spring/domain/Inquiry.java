package umc.spring.domain;

import umc.spring.domain.common.BaseEntity;

import lombok.*;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.enums.InquiryStatus;
import umc.spring.domain.enums.NotificationStatus;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Inquiry extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT")
    private Long id;

    @Column(length = 30, columnDefinition = "VARCHAR(30)")
    private String title;

    @Lob
    private String detail;

    @Column(length = 50, columnDefinition = "VARCHAR(50)")
    private String fileUrl;

    @Lob
    private String response;

    @Enumerated(EnumType.STRING)
    @Column(length = 10, columnDefinition = "VARCHAR(10)")
    private InquiryStatus inquiryStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", columnDefinition = "BIGINT")
    private Member member;

}
