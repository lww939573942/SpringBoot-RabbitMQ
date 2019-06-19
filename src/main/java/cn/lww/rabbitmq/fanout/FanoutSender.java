package cn.lww.rabbitmq.fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author lww
 *
 * 消息发送器
 */
@Component
public class FanoutSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void sendMessage() {
        String message = "fanout message";
        System.out.println("发送消息 : " + message);
        this.rabbitTemplate.convertAndSend(FanoutConfig.FANOUT_EXCHANGE, "", message);
    }

}
