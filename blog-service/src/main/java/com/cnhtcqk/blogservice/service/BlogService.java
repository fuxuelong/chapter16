package com.cnhtcqk.blogservice.service;


import com.cnhtcqk.blogservice.client.UserServiceClient;
import com.cnhtcqk.blogservice.dao.BlogDao;
import com.cnhtcqk.blogservice.dto.BlogDetailDTO;
import com.cnhtcqk.blogservice.entity.Blog;
import com.cnhtcqk.blogservice.entity.User;
import com.cnhtcqk.blogservice.util.UserUtils;
import com.forezp.dto.RespDTO;
import com.forezp.exception.CommonException;
import com.forezp.exception.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.OpenOption;
import java.util.List;
import java.util.Optional;


/**
 * Created by fangzhipeng on 2017/7/10.
 */
@Service
public class BlogService {

    @Autowired
    BlogDao blogDao;

    @Autowired
    UserServiceClient userServiceClient;

    public Blog postBlog(Blog blog) {
        return blogDao.save(blog);
    }

    public List<Blog> findBlogs(String username) {
        return blogDao.findByUsername(username);
    }


    public BlogDetailDTO findBlogDetail(Long id) {
        Blog b = new Blog();
        b.setId(id);
        Blog blog = blogDao.findById(id).get();
        if (null == blog) {
            throw new CommonException(ErrorCode.BLOG_IS_NOT_EXIST);
        }
        RespDTO<User> respDTO = userServiceClient.getUser(UserUtils.getCurrentToken(), blog.getUsername());
        if (respDTO==null) {
            throw new CommonException(ErrorCode.RPC_ERROR);
        }
        BlogDetailDTO blogDetailDTO = new BlogDetailDTO();
        blogDetailDTO.setBlog(blog);
        blogDetailDTO.setUser(respDTO.data);
        return blogDetailDTO;
    }

}
