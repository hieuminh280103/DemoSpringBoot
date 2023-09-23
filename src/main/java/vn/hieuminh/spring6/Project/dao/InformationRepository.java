package vn.hieuminh.spring6.Project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.hieuminh.spring6.Project.entity.Information;

@Repository
public interface InformationRepository extends JpaRepository<Information,Long> {

    @Query("SELECT i FROM Information i WHERE i.id=:x")
    Information findInformationById(@Param("x")long id);
}
