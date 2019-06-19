package cn.lww.rabbitmq.topic;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author lww
 *
 * 消息接收器A，接收A队列发来的消息
 */
@Component
public class TopicReceiver {

    @RabbitListener(queues = TopicConfig.QUEUE_TOPIC_A)
    public void processA(String message) {
        System.out.println(this.getClass().getName() + " A队列 接收到消息:" + message);
    }

    @RabbitListener(queues = TopicConfig.QUEUE_TOPIC_B)
    public void processB(String message) {
        System.out.println(this.getClass().getName() + " B队列 接收到消息:" + message);
    }

}