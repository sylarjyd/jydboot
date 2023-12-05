package com.jyd.config.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class RabbitPubConfig {

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate createRabbitTemplate(ConnectionFactory connectionFactory){
        log.info("rabbitmq ip :{},port:{},virtualHost:{}",connectionFactory.getHost(),connectionFactory.getPort(),connectionFactory.getVirtualHost());
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());

        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
           log.info("ConfirmCallback ack：{}, correlationData: {}, cause：{}",ack, correlationData, cause);
        });

        rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> {
            log.info("ReturnCallback message：{},exchange: {}, routingKey: {}, replyCode: {}, replyText: {}",
                    message,exchange,routingKey,replyCode,replyText);
        });
        return rabbitTemplate;
    }

    @Bean
    public SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory(ConnectionFactory factory){
        SimpleRabbitListenerContainerFactory srlcf = new SimpleRabbitListenerContainerFactory();
        srlcf.setConnectionFactory(factory);
        //当消息有异常内容时（例如类型不匹配），将不再重新放入队列，直接丢弃
        srlcf.setDefaultRequeueRejected(false);
        //设置消息转为json
        srlcf.setMessageConverter(jsonMessageConverter());
        return srlcf;
    }

}
