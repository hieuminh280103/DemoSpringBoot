package vn.hieuminh.spring6.Project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.hieuminh.spring6.Project.entity.Staff;
import vn.hieuminh.spring6.Project.entity.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    @Query("SELECT s FROM Student s WHERE s.id=:x")
    Student findStudentById(@Param("x") long id);
}
