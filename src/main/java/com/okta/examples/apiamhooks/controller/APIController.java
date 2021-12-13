package com.okta.examples.apiamhooks.controller;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class APIController {


    @RequestMapping("/")
    public String health() {
        return "Service";
    }
    @RequestMapping("/health")
    public String healthcheck() {
        return "OK";
    }


}
