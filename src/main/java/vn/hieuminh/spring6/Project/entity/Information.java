package vn.hieuminh.spring6.Project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Blob;
import java.sql.Date;

@Entity
@Table(name="information")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Information {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="name",length = 256)
    private String name;

    @Column(name="gender")
    private String gender;

    @Column(name="date")
    private Date date;

    @Column(name="address",length = 256)
    private String address;

    @Column(name="hobby",length = 256)
    private String hobby;

    @Column(name="avatar")
    @Lob
    private Blob avatar;

    @Column(name="phone_number")
    private long phoneNumber;
}
