package message.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Table(name = "members", schema = "ync",
        indexes = {@Index(name = "IDX_MEMBER_DELECT_STAUTS", columnList = "DELECT_STATUS")})
@SequenceGenerator(name = "MEMEBER_SEQ", schema = "YNC", allocationSize = 1, sequenceName = "MEMBER_SEQ")
@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQ")
    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "email", length = 320)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "tel", length = 14)
    private String tel;

    @Column(name = "name", length = 60)
    private String name;

    @Column(name = "delect_status")
    private Long delectStatus;

    @Column(name = "role")
    private Long role;
}
