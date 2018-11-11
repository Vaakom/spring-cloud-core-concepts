package com.core.springcloud.eurekaclient.controllers;

import com.core.springcloud.eurekaclient.domain.User;
import com.netflix.appinfo.InstanceInfo;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class WelcomeController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping(path = "/user")
    private User getUser(){

        return new User(
                getInfoString("eureka-client-one", "name"),
                getInfoString("eureka-client-two", "email"),
                getInfoString("eureka-client-three", "address")
        );
    }

    public String getInfoString(String clientId, String resource) {
        List<ServiceInstance> instanceList = discoveryClient.getInstances(clientId);

        for(ServiceInstance instance : instanceList){
            String url = instance.getUri().toString() + "/" + resource;

            RestTemplate restTemplate = new RestTemplate();

            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            return response.getBody();
        }

        return null;
    }
}
