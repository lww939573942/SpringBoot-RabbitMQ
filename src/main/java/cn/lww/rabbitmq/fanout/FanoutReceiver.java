package cn.lww.rabbitmq.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author lww
 *
 * 消息接收器
 */
@Component
public class FanoutReceiver {

    @RabbitListener(queues = FanoutConfig.FANOUT_QUEUE_A)
    public void processA(String message) {
        System.out.println(this.getClass().getName() + " A队列 接收到消息:" + message);
    }

    @RabbitListener(queues = FanoutConfig.FANOUT_QUEUE_B)
    public void processB(String message) {
        System.out.println(this.getClass().getName() + " B队列 接收到消息:" + message);
    }

    @RabbitListener(queues = FanoutConfig.FANOUT_QUEUE_C)
    public void processC(String message) {
        System.out.println(this.getClass().getName() + " C队列 接收到消息:" + message);
    }
}