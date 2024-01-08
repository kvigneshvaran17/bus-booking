package com.busbooking.dao;

import com.busbooking.model.user.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends CrudRepository<User,Integer> {
    @Query("SELECT u from User u where u.loginId = :loginId")
    Optional<User> findByLoginId(@Param("loginId") String loginId);
}
