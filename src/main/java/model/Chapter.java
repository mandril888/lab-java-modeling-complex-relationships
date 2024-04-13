package model;

import jakarta.persistence.*;
import java.util.List;

import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "chapter")
@NoArgsConstructor
public class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int chapterId;
    private String name;
    private String district;

    @OneToOne
    @JoinColumn(name="president_id")
    private Member president;

    @ManyToOne
    @JoinColumn(name="association_id")
    private Association association;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Member> list;

    public Chapter(String name, String district, Member president, Association association, List<Member> list) {
        this.name = name;
        this.district = district;
        this.president = president;
        this.association = association;
        this.list = list;
    }
}