package vn.hieuminh.spring6.Project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.hieuminh.spring6.Project.entity.SubjectScore;
import vn.hieuminh.spring6.Project.entity.Transcript;

@Repository
public interface TranscriptRepository extends JpaRepository<Transcript,Long> {
    @Query("SELECT t FROM Transcript t WHERE t.id=:x")
    Transcript findTranscriptById(@Param("x") long id);
}
