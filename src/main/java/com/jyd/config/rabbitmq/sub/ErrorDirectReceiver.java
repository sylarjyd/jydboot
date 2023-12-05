package com.jyd.config.rabbitmq.sub;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RabbitListener(queues = "errorDirectQueue")
@Slf4j
public class ErrorDirectReceiver {

    @RabbitHandler
    public void process(@Payload String messageBody, Message message, Channel channel) {
        try {
            log.info("ErrorDirectReceiver消费者收到消息 : {}", messageBody);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        } catch (IOException e) {
            try {
                channel.basicReject(message.getMessageProperties().getDeliveryTag(),false);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            e.printStackTrace();
        }
    }

}
