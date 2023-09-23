package vn.hieuminh.spring6.Project.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name="notebook")
public class Notebook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @OneToOne(fetch = FetchType.EAGER,cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="class_id")
    private Class aClass;

    @Column(name="date")
    private Date date;

    @Column(name="title")
    private String title;
}
