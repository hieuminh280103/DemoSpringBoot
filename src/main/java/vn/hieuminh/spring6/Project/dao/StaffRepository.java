package vn.hieuminh.spring6.Project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.hieuminh.spring6.Project.entity.Information;
import vn.hieuminh.spring6.Project.entity.School;
import vn.hieuminh.spring6.Project.entity.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff,Long> {
    @Query("SELECT s FROM Staff s WHERE s.id=:x")
    Staff findStaffById(@Param("x") long id);

    @Query("SELECT s.information FROM Staff s WHERE s.id=:x")
    Information findInformationByStaffId(@Param("x") long id);
}
