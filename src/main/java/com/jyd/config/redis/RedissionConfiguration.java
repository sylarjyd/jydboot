package com.jyd.config.redis;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class RedissionConfiguration {

    @Value("${spring.redis.database}")
    private Integer database;

    @Value("${spring.redis.password}")
    private String password;

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private Integer port;

    @Bean(destroyMethod = "shutdown")
    RedissonClient redisson() {
        Config config = new Config();
        if(StrUtil.isNotEmpty(password)){
            config.useSingleServer().setAddress("redis://" + host + ":" + port).setPassword(password).setDatabase(database);
        }else{
            config.useSingleServer().setAddress("redis://" + host + ":" + port).setDatabase(database);
        }
        return Redisson.create(config);
    }
}
