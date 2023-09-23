package vn.hieuminh.spring6.Project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.hieuminh.spring6.Project.entity.Notebook;
import vn.hieuminh.spring6.Project.entity.Parent;

@Repository
public interface ParentRepository extends JpaRepository<Parent,Long> {
    @Query("SELECT p FROM Parent p WHERE p.id=:x")
    Parent findParentById(@Param("x") long id);
}
