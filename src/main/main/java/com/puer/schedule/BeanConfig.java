package com.puer.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BeanConfig {
    @Autowired
    private RestTemplateBuilder restBuilder;

    @Bean
    public RestTemplate restTemplate() {
        return restBuilder.build();
    }


}
