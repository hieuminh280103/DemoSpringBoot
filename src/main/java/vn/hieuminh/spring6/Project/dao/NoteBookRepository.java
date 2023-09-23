package vn.hieuminh.spring6.Project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.hieuminh.spring6.Project.entity.Notebook;
import vn.hieuminh.spring6.Project.entity.School;
import vn.hieuminh.spring6.Project.entity.SubjectScore;

@Repository
public interface NoteBookRepository extends JpaRepository<Notebook,Long> {
    @Query("SELECT n FROM Notebook n WHERE n.id=:x")
    Notebook findNotebookById(@Param("x") long id);
}
