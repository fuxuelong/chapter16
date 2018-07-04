package com.cnhtcqk.blogservice.dao;

import com.cnhtcqk.blogservice.entity.Blog;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by fangzhipeng on 2017/7/10.
 */

public interface BlogDao extends JpaRepository<Blog, Long> {

    List<Blog> findByUsername(String username);

}
