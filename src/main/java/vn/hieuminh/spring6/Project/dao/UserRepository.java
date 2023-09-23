package vn.hieuminh.spring6.Project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.hieuminh.spring6.Project.entity.Staff;
import vn.hieuminh.spring6.Project.entity.Transcript;
import vn.hieuminh.spring6.Project.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    @Query("SELECT u FROM User u WHERE u.username=:x")
    User findUserByUsername(@Param("x") String username);

    @Query("SELECT u FROM User u")
    List<User> findAllUser();

    @Query("SELECT u.staff FROM User u WHERE u.username=:x")
    Staff findStaffByUsername(@Param("x") String username);
}
