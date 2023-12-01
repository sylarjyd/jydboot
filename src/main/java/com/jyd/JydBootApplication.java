package com.jyd;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude ={DataSourceAutoConfiguration.class, DruidDataSourceAutoConfigure.class})
@MapperScan(value = "com.jyd.mapper")
@ComponentScan(basePackages = {"com.jyd.**"})
@EnableTransactionManagement
@ServletComponentScan
public class JydBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(JydBootApplication.class, args);
    }
}
