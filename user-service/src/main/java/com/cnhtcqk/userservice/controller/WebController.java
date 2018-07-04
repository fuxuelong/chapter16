package com.cnhtcqk.userservice.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author fuxuelong
 */
@RestController
@RequestMapping("/foo")
public class WebController {

    @RequestMapping(method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String getFoo() {
        return "i'm foo, " + UUID.randomUUID().toString();
    }


}
