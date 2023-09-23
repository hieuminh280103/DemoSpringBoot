package vn.hieuminh.spring6.Project.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="transcript")
public class Transcript {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @OneToOne(fetch = FetchType.EAGER, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="student_id")
    private Student student;

    @OneToMany(mappedBy = "transcript",fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<SubjectScore> subjectScrores;
}
