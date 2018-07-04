package com.cnhtcqk.blogservice.client.hystrix;


import com.cnhtcqk.blogservice.client.UserServiceClient;
import com.cnhtcqk.blogservice.entity.User;
import com.forezp.dto.RespDTO;
import org.springframework.stereotype.Component;


/**
 * Created by fangzhipeng on 2017/5/31.
 */
@Component
public class UserServiceHystrix implements UserServiceClient {

    @Override
    public RespDTO<User> getUser(String token, String username) {
        System.out.println(token);
        System.out.println(username);
        return null;
    }
}
