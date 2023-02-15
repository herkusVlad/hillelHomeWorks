package POJO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @ManyToOne
    private Teacher teacher;

    @Column
    private int semester;

    @Column(length = 4)
    private int year;

    @OneToMany(mappedBy = "lesson")
    private List<Point> points = new ArrayList<>();
}
