package model;

import enums.MemberStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@Getter
@Setter
@Entity
@Table(name = "member")
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberId;
    private String name;
    @Enumerated (EnumType.STRING)
    private MemberStatus status;
    private Date renewalDate;

    @ManyToOne
    private Chapter chapter;

    public Member(String name, MemberStatus status, Date renewalDate, Chapter chapter) {
        this.name = name;
        this.status = status;
        this.renewalDate = renewalDate;
        this.chapter = chapter;
    }
}
