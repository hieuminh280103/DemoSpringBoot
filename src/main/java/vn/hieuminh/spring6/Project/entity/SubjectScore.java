package vn.hieuminh.spring6.Project.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name="subject_score")
public class SubjectScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @OneToOne(fetch = FetchType.LAZY,
        cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
        }
    )
    @JoinColumn(name="subject_id")
    private Subject subject;

    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Transcript transcript;

    @Column(name="score")
    private double score;

    @Column(name="semester")
    private String semester;
}
