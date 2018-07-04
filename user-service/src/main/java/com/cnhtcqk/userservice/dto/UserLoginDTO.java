package com.cnhtcqk.userservice.dto;

import com.cnhtcqk.userservice.entity.Jwt;
import com.cnhtcqk.userservice.entity.User;

/**
 * @author fuxuelong
 */
public class UserLoginDTO {
    private Jwt jwt;

    private User user;

    public Jwt getJwt() {
        return jwt;
    }

    public void setJwt(Jwt jwt) {
        this.jwt = jwt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
