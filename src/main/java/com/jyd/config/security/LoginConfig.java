package com.jyd.config.security;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "login")
public class LoginConfig {

    private String secret;
    private Long expire;
    private List<String> skipurl;

}
