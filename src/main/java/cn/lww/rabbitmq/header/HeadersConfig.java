package cn.lww.rabbitmq.header;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lww
 *
 * headers 交换机类型 配置
 * 根据header键值对匹配
 */
@Configuration
public class HeadersConfig {

    /**
     * 队列all
     */
    public final static String HEADERS_QUEUE_ALL = "headers_queue_all";

    /**
     * 队列any
     */
    public final static String HEADERS_QUEUE_ANY = "headers_queue_any";

    /**
     * 交换机
     */
    public final static String HEADERS_EXCHANGE = "headers_exchange";

    /**
     * headers 键值对
     */
    public final static Map<String,Object> headersMap = new HashMap<>();
    static {
        headersMap.put("version","1.0.1");
        headersMap.put("method","post");
    }


    @Bean
    public Queue headersQueueAll() {
        return new Queue(HeadersConfig.HEADERS_QUEUE_ALL);
    }

    @Bean
    public Queue headersQueueAny() {
        return new Queue(HeadersConfig.HEADERS_QUEUE_ANY);
    }


    /**
     * 声明一个Headers类型的交换机
     * @return
     */
    @Bean
    HeadersExchange headersExchange() {
        return new HeadersExchange(HEADERS_EXCHANGE);
    }

    /**
     * 绑定队列到交换机,
     * @param headersQueueAll
     * @param headersExchange
     * @return
     */
    @Bean
    Binding bindingHeadersQueueAll(Queue headersQueueAll, HeadersExchange headersExchange) {
        //whereAll全匹配
        return BindingBuilder.bind(headersQueueAll).to(headersExchange).whereAll(headersMap).match();
    }

    @Bean
    Binding bindingHeadersQueueAny(Queue headersQueueAny, HeadersExchange headersExchange) {
        //whereAny匹配其中一项即可
        return BindingBuilder.bind(headersQueueAny).to(headersExchange).whereAny(headersMap).match();
    }

}