package com.ahbap.geonames.geonames.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Tamplet {

    @Bean
    @Scope("prototype")
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }
}
