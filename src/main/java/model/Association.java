package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Entity
@NoArgsConstructor
public class Association {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy="association", fetch = FetchType.LAZY)
    private List<Chapter> listOfChapters;

    public Association(String name, List<Chapter> listOfChapters) {
        this.name = name;
        this.listOfChapters = listOfChapters;
    }
}
