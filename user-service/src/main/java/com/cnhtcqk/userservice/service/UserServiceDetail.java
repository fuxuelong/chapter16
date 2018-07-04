package com.cnhtcqk.userservice.service;


import com.cnhtcqk.userservice.client.AuthServiceClient;
import com.cnhtcqk.userservice.dao.UserDao;
import com.cnhtcqk.userservice.dto.UserLoginDTO;
import com.cnhtcqk.userservice.entity.Jwt;
import com.cnhtcqk.userservice.entity.User;
import com.cnhtcqk.userservice.exception.UserLoginException;
import com.cnhtcqk.userservice.utils.BPwdEncoderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 * Created by fangzhipeng on 2017/5/10.
 */
@Service
public class UserServiceDetail  {

    @Autowired
    private UserDao userRepository;
    @Autowired
    AuthServiceClient client;

    public User insertUser(String username, String  password){
        User user=new User();
        user.setUsername(username);
        user.setPassword(BPwdEncoderUtil.BCryptPassword(password));
        return userRepository.save(user);
    }
    public UserLoginDTO login(String username, String password){
        User user=userRepository.findByUsername(username);
        if (null == user) {
            throw new UserLoginException("error username");
        }
        if(!BPwdEncoderUtil.matches(password,user.getPassword())){
            throw new UserLoginException("error password");
        }
        // 获取token
        Jwt jwt=client.getToken("Basic dXNlci1zZXJ2aWNlOjEyMzQ1Ng==","password",username,password);
        // 获得用户菜单
        if(jwt==null){
            throw new UserLoginException("error internal");
        }
        UserLoginDTO userLoginDTO=new UserLoginDTO();
        userLoginDTO.setJwt(jwt);
        userLoginDTO.setUser(user);
        return userLoginDTO;

    }

}