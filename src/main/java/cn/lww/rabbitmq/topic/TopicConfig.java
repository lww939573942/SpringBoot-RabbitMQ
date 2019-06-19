package cn.lww.rabbitmq.topic;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lww
 *
 * Topic 交换机类型 配置
 * 根据通配符转发消息
 */
@Configuration
public class TopicConfig {

    /**
     * 队列A
     */
    public final static String QUEUE_TOPIC_A = "queue_topic_a";

    /**
     * 队列B
     */
    public final static String QUEUE_TOPIC_B = "queue_topic_b";

    /**
     * 交换机
     */
    public final static String TOPIC_EXCHANGE = "topic_exchange";

    @Bean
    public Queue topicQueueA() {
        return new Queue(TopicConfig.QUEUE_TOPIC_A);
    }

    @Bean
    public Queue topicQueueB() {
        return new Queue(TopicConfig.QUEUE_TOPIC_B);
    }

    /**
     * 声明一个Topic类型的交换机
     * @return
     */
    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange(TOPIC_EXCHANGE);
    }

    /**
     * 绑定队列A到交换机,并且指定routingKey
     * @param topicQueueA
     * @param topicExchange
     * @return
     */
    @Bean
    Binding bindingTopicQueueA(Queue topicQueueA, TopicExchange topicExchange) {
        return BindingBuilder.bind(topicQueueA).to(topicExchange).with("topic.message.a.*");
    }

    /**
     * 绑定队列B到交换机,并且指定routingKey
     * @param topicQueueB
     * @param topicExchange
     * @return
     */
    @Bean
    Binding bindingTopicQueueB(Queue topicQueueB, TopicExchange topicExchange) {
        return BindingBuilder.bind(topicQueueB).to(topicExchange).with("topic.message.b.*");
    }
}