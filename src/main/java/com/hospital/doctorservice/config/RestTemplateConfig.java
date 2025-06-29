// RestTemplateConfig.java
package com.hospital.doctorservice.config;
import org.springframework.context.annotation.*;
import org.springframework.web.client.RestTemplate;
@Configuration
public class RestTemplateConfig {
    @Bean RestTemplate restTemplate() { return new RestTemplate(); }
}