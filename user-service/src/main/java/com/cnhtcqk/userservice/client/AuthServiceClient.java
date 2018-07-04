package com.cnhtcqk.userservice.client;

import com.cnhtcqk.userservice.client.hystrix.AuthServiceHystrix;
import com.cnhtcqk.userservice.entity.Jwt;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by fangzhipeng on 2017/5/27.
 */

@FeignClient(value = "uaa-service",fallback =AuthServiceHystrix.class )
public interface AuthServiceClient {

    @PostMapping(value = "/oauth/token")
    Jwt getToken(@RequestHeader(value = "Authorization") String authorization, @RequestParam("grant_type") String type,
                 @RequestParam("username") String username, @RequestParam("password") String password);

}
