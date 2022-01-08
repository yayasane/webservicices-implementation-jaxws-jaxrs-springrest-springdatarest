package com.yayasn.msbanque.config;

import com.yayasn.msbanque.web.AccountRestJaxRSAPI;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    // @Bean
    public ResourceConfig resourceConfig() {
        ResourceConfig jerseyServelet = new ResourceConfig();
        jerseyServelet.register(AccountRestJaxRSAPI.class);
        return jerseyServelet;
    }

}
