package vn.hieuminh.spring6.Project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.hieuminh.spring6.Project.entity.School;

@Repository
public interface SchoolRepository extends JpaRepository<School,Long> {
    @Query("SELECT s FROM School s WHERE s.id=:x")
    School findSchoolById(@Param("x") long id);
}
