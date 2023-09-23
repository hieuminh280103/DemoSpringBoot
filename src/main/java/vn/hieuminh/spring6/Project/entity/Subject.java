package vn.hieuminh.spring6.Project.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="name")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH
            }
    )
    @JoinTable(
            name="subject_staff",
            joinColumns = @JoinColumn(name="subject_id"),
            inverseJoinColumns = @JoinColumn(name="staff_id")
    )
    private List<Staff> staffs;
}
