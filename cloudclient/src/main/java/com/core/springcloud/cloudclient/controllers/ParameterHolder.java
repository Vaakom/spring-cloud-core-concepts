package com.core.springcloud.cloudclient.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ParameterHolder {

    @Value("${cloud-client}")
    private String cloudClient;

    @Value("${one-little-parameter}")
    private String oneLittleParameter;

    public String getCloudClient() {
        return cloudClient;
    }

    public String getOneLittleParameter() {
        return oneLittleParameter;
    }
}
