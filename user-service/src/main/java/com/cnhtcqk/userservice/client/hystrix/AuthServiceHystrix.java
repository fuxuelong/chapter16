package com.cnhtcqk.userservice.client.hystrix;

import com.cnhtcqk.userservice.client.AuthServiceClient;
import com.cnhtcqk.userservice.entity.Jwt;
import org.springframework.stereotype.Component;

/**
 *
 * @author fuxuelong
 * @date 2017/5/31
 */
@Component
public class AuthServiceHystrix implements AuthServiceClient {
    @Override
    public Jwt getToken(String authorization, String type, String username, String password) {
        return null;
    }
}
