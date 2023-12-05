package com.jyd.config.rabbitmq.sub;

import com.jyd.config.rabbitmq.pub.DirectRabbitConfig;
import com.jyd.config.rabbitmq.pub.ErrorMessageConfig;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RabbitListener(queues = DirectRabbitConfig.TEST_DIRECT_QUEUE)
@Slf4j
public class DirectReceiver {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RabbitHandler
    public void process(@Payload String messageBody, Message message, Channel channel) {
        try {
            log.info("DirectReceiver消费者收到消息:{}",messageBody);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),true);
        } catch (Exception e) {
            try {
                channel.basicReject(message.getMessageProperties().getDeliveryTag(),false);

                CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
                rabbitTemplate.convertAndSend(ErrorMessageConfig.ERROR_DIRECT_EXCHANGE,ErrorMessageConfig.ERROR_DIRECT_ROUTING,messageBody,correlationData);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }

}
