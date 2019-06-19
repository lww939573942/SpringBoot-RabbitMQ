package cn.lww.rabbitmq.header;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author lww
 *
 * 消息发送器
 */
@Component
public class HeaderSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void sendMessage() {
        String text = "headers message";
        System.out.println("发送消息 : " + text);
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setHeader("version","1.0.1");
//        messageProperties.setHeader("method","post");    //放开这行，则All 跟 Any 都能接收到消息
        Message message = new Message(text.getBytes(),messageProperties);
        this.rabbitTemplate.convertAndSend(HeadersConfig.HEADERS_EXCHANGE,null,message);
    }

}
