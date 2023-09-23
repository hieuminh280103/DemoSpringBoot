package vn.hieuminh.spring6.Project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="class")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="name",length = 256)
    private String name;

    @Column(name="grade")
    private int grade;

    @Column(name="session")
    private int session;


    @OneToOne(fetch = FetchType.LAZY,
            cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
            }
    )
    @JoinColumn(name="form_staff_id")
    private Staff formStaff;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH
            }
    )
    @JoinTable(
            name="class_staff",
            joinColumns = @JoinColumn(name="class_id"),
            inverseJoinColumns = @JoinColumn(name="staff_id")
    )
    private List<Staff> staffs;

    @OneToOne(fetch = FetchType.EAGER,
            cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
            }
    )
    @JoinColumn(name="school_id")
    private School school;

    @OneToMany(mappedBy = "aClass",
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH
            }
    )
    private List<Student> students;

    @Override
    public String toString() {
        return "Class{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", session=" + session +
                '}';
    }
}
