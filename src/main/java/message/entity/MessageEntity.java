package message.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.time.LocalDateTime;

/* 기본값
* ID
* status*/
@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "messages", schema = "YNC")
@SequenceGenerator(name = "message_seq", schema = "YNC",
        allocationSize = 1, sequenceName = "message_seq")
public class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "message_seq")
    @Column(name = "message_id")
    private Long messageId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id", referencedColumnName = "member_id")
    private MemberEntity senderMember;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_id", referencedColumnName = "member_id")
    private MemberEntity receiverMember;

    @Lob
    @Column(nullable = false, name = "content")
    private String Content;

    @Column(nullable = false, name = "send_date")
    private LocalDateTime sendDate;

    @Column(name = "read_status")
    private Long readStatus;

    @Column(name = "arch_status")
    private Long archStatus;

    @Column(name = "delect_status")
    private Long delectStatus;

    @Column(name = "report_status")
    private Long reportStatus;
}