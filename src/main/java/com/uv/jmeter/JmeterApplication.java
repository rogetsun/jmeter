package com.uv.jmeter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class JmeterApplication {

    public static void main(String[] args) {
        SpringApplication.run(JmeterApplication.class, args);
    }

}
