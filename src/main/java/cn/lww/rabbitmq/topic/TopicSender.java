package cn.lww.rabbitmq.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author lww
 *
 * 消息发送器
 */
@Component
public class TopicSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void sendMessageA() {
        String message = "topic message A";
        System.out.println("发送消息 : " + message);
        this.rabbitTemplate.convertAndSend(TopicConfig.TOPIC_EXCHANGE, "topic.message.a.test", message);
    }


    public void sendMessageB() {
        String message = "topic message B";
        System.out.println("发送消息 : " + message);
        this.rabbitTemplate.convertAndSend(TopicConfig.TOPIC_EXCHANGE, "topic.message.b.11111", message);
    }
}
