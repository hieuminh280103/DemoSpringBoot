package vn.hieuminh.spring6.Project.entity;

import jakarta.persistence.*;

@Entity
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @OneToOne(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    @JoinColumn(name="information_id")
    private Information information;

    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH
            }
    )
    @JoinColumn(name="class_id")
    private Class aClass;

    @OneToOne(mappedBy = "student", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Parent parent;
}
