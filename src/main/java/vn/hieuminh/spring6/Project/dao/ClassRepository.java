package vn.hieuminh.spring6.Project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.hieuminh.spring6.Project.entity.Class;

@Repository
public interface ClassRepository extends JpaRepository<Class,Long> {
    @Query("SELECT c FROM Class c WHERE c.id=:x")
    Class findClassById(@Param("x") long id);
}
