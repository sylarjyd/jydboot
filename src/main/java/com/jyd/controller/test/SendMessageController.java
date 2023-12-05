package com.jyd.controller.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.jyd.config.rabbitmq.MessageEntity;
import com.jyd.config.rabbitmq.pub.DirectRabbitConfig;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = ("/test"))
@Api(value = "测试", tags = "测试接口")
@Slf4j
public class SendMessageController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/sendDirectMessage")
    public String sendDirectMessage() throws Exception {
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        String messageBody = "test message, hello!";
        MessageEntity messageEntity = MessageEntity.build(messageBody);
        rabbitTemplate.convertAndSend(DirectRabbitConfig.TEST_DIRECT_EXCHANGE, DirectRabbitConfig.TEST_DIRECT_ROUTING, JSON.toJSONString(messageEntity,SerializerFeature.WriteMapNullValue),correlationData);
        return "ok";
    }

}
