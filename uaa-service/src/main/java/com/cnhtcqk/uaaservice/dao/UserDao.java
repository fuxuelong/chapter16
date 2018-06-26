package com.cnhtcqk.uaaservice.dao;

import com.cnhtcqk.uaaservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author fuxuelong
 */
public interface UserDao extends JpaRepository<User,Long> {

    User findByUsername(String username);
}
