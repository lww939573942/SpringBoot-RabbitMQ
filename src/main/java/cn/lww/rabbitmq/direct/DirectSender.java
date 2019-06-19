package cn.lww.rabbitmq.direct;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author lww
 *
 * 消息发送器
 */
@Component
public class DirectSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void sendMessage() {
        String message = "direct message";
        System.out.println("发送消息 : " + message);
        this.rabbitTemplate.convertAndSend(DirectConfig.DIRECT_QUEUE,message);
    }

}
