package com.jyd.config.rabbitmq.pub;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectRabbitConfig {

    public static final String TEST_DIRECT_EXCHANGE = "testDirectExchange";
    public static final String TEST_DIRECT_QUEUE = "testDirectQueue";
    public static final String TEST_DIRECT_ROUTING = "testDirectRouting";

    @Bean
    DirectExchange testDirectExchange() {
        return new DirectExchange(TEST_DIRECT_EXCHANGE,true,false);
    }

    @Bean
    public Queue testDirectQueue() {
        return new Queue(TEST_DIRECT_QUEUE,true);
    }

    @Bean
    Binding bindingDirect() {
        return BindingBuilder.bind(testDirectQueue()).to(testDirectExchange()).with(TEST_DIRECT_ROUTING);
    }

}
