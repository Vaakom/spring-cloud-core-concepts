package com.core.springcloud.eurekaclient.controllers;

import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    private DataFactory dataFactory = new DataFactory();

    @GetMapping(path = "/name")
    private String getName(){
        return dataFactory.getName();
    }
}
