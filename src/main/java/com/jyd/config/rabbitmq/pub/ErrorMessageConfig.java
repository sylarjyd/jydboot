package com.jyd.config.rabbitmq.pub;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ErrorMessageConfig {

    public static final String ERROR_DIRECT_EXCHANGE = "errorDirectExchange";
    public static final String ERROR_DIRECT_QUEUE = "errorDirectQueue";
    public static final String ERROR_DIRECT_ROUTING = "errorDirectRouting";

    @Bean
    public DirectExchange errorMessageExchange(){
        return new DirectExchange(ERROR_DIRECT_EXCHANGE,true,false);
    }

    @Bean
    public Queue errorDirectQueue(){
        return new Queue(ERROR_DIRECT_QUEUE,true);
    }

    @Bean
    public Binding errorMessageBinding(){
        return BindingBuilder.bind(errorDirectQueue()).to(errorMessageExchange()).with(ERROR_DIRECT_ROUTING);
    }

}
