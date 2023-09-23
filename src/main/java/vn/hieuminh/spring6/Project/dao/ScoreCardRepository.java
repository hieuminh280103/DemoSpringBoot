package vn.hieuminh.spring6.Project.dao;

import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.hieuminh.spring6.Project.entity.School;
import vn.hieuminh.spring6.Project.entity.ScoreCard;

@Repository
public interface ScoreCardRepository extends JpaRepository<ScoreCard,Long> {
    @Query("SELECT s FROM ScoreCard s WHERE s.id=:x")
    ScoreCard findScoreCardById(@Param("x") long id);
}
