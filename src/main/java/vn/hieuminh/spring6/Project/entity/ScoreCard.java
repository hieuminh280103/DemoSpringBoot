package vn.hieuminh.spring6.Project.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name="score_card")
public class ScoreCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="student_id")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="subject_id")
    private Subject subject;

    @Column(name="score")
    private double score;

    @Column(name="date")
    private Date date;
}
