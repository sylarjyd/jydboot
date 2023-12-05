package com.jyd.config.rabbitmq;

import cn.hutool.core.util.IdUtil;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class MessageEntity implements Serializable {

    public static final String CREATE_TIME_PATTERN= "yyyy-MM-dd HH:mm:ss";
    private String messageId;
    private Object messageBody;
    private String createTime;

    public static MessageEntity build(Object messageBody) {
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setMessageId(IdUtil.fastSimpleUUID());
        messageEntity.setCreateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern(CREATE_TIME_PATTERN)));
        messageEntity.setMessageBody(messageBody);
        return messageEntity;
    }

    @Override
    public String toString() {
        return "MessageEntity{" +
                "messageId='" + messageId + '\'' +
                ", messageBody=" + messageBody +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
