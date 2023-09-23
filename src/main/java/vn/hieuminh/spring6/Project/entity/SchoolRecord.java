package vn.hieuminh.spring6.Project.entity;

import jakarta.persistence.*;

@Entity
@Table(name="school_record")
public class SchoolRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @OneToOne(fetch = FetchType.EAGER, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="transcript_id")
    private Transcript transcript;

    @Column(name="study_level")
    private String studyLevel;

    @Column(name="teacher_comment")
    private String teacherComment;

    @Column(name="parent_comment")
    private String parentComment;
}
