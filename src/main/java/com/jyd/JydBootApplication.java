package com.jyd;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class, MybatisPlusAutoConfiguration.class})
@MapperScan("com.jyd.mapper")
@ComponentScan(basePackages = {"com.jyd.**"})
public class JydBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(JydBootApplication.class, args);
    }
}
