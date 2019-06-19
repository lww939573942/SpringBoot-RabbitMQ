package cn.lww.rabbitmq.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author lww
 *
 * 消息接收器
 */
@Component
@RabbitListener(queues = DirectConfig.DIRECT_QUEUE)
public class DirectReceiver {

    @RabbitHandler
    public void process(String message) {
        System.out.println(this.getClass().getName() + "接收到消息:" + message);
    }

}