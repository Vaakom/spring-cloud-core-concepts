package com.core.springcloud.cloudclient.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Autowired
    private ParameterHolder parameterHolder;

    @GetMapping(path = "/parameters")
    public ParameterHolder getConfigParameters(){
        return parameterHolder;
    }
}
