package cn.lww.rabbitmq.header;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author lww
 *
 * 消息接收器
 */
@Component
public class HeadersReceiver {

    @RabbitListener(queues = HeadersConfig.HEADERS_QUEUE_ALL)
    public void processAll(byte[] bytes) {
        System.out.println(this.getClass().getName() + " all 接收到消息:" + new String(bytes));
    }

    @RabbitListener(queues = HeadersConfig.HEADERS_QUEUE_ANY)
    public void processAny(byte[] bytes) {
        System.out.println(this.getClass().getName() + " any 接收到消息:" + new String(bytes));
    }


}