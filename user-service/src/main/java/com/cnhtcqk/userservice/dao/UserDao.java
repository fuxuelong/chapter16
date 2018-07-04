package com.cnhtcqk.userservice.dao;


import com.cnhtcqk.userservice.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author fuxuelong
 */
public interface UserDao extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
