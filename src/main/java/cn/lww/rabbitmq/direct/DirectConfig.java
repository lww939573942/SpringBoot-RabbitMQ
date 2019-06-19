package cn.lww.rabbitmq.direct;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lww
 *
 * direct 交换机类型 配置
 * 默认的交换机模式,根据key全文匹配去寻找队列
 */
@Configuration
public class DirectConfig {

    /**
     * 队列
     */
    public final static String DIRECT_QUEUE = "direct_queue";

    /**
     * 交换机
     */
    public final static String DIRECT_EXCHANGE = "direct_exchange";

    /**
     * 绑定routingKey
     */
    public final static String routingKey = "my_direct_key";

    @Bean
    public Queue directQueue() {
        return new Queue(DirectConfig.DIRECT_QUEUE);
    }


    /**
     * 声明一个Direct类型的交换机
     * @return
     */
    @Bean
    DirectExchange directExchange() {
        return new DirectExchange(DIRECT_EXCHANGE);
    }

    /**
     * 绑定队列A到交换机,并且指定routingKey
     * @param directQueue
     * @param directExchange
     * @return
     */
    @Bean
    Binding bindingDirectQueue(Queue directQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(directQueue).to(directExchange).with(routingKey);
    }

}