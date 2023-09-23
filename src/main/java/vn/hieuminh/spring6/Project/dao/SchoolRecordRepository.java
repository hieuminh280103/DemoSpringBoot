package vn.hieuminh.spring6.Project.dao;

import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.hieuminh.spring6.Project.entity.Parent;
import vn.hieuminh.spring6.Project.entity.SchoolRecord;

@Repository
public interface SchoolRecordRepository extends JpaRepository<SchoolRecord,Long> {
    @Query("SELECT s FROM SchoolRecord s WHERE s.id=:x")
    SchoolRecord findSchoolRecordById(@Param("x") long id);
}
