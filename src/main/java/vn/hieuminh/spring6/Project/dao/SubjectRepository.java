package vn.hieuminh.spring6.Project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.hieuminh.spring6.Project.entity.Student;
import vn.hieuminh.spring6.Project.entity.Subject;
@Repository
public interface SubjectRepository extends JpaRepository<Subject,Long> {
    @Query("SELECT s FROM Subject s WHERE s.id=:x")
    Subject findSubjectById(@Param("x") long id);
}
