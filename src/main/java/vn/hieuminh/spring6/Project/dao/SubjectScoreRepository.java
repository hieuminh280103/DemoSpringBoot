package vn.hieuminh.spring6.Project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.hieuminh.spring6.Project.entity.Subject;
import vn.hieuminh.spring6.Project.entity.SubjectScore;
@Repository
public interface SubjectScoreRepository extends JpaRepository<SubjectScore,Long> {
    @Query("SELECT s FROM SubjectScore s WHERE s.id=:x")
    SubjectScore findSubjectScoreById(@Param("x") long id);
}
