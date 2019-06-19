package cn.lww.rabbitmq.fanout;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * @author lww
 *
 * fanout 交换机类型 配置
 * 广播的模式 发送给绑定的所有队列
 */
@Configuration
public class FanoutConfig {

    /**
     * 队列A
     */
    public final static String FANOUT_QUEUE_A = "fanout_queue_A";

    /**
     * 队列B
     */
    public final static String FANOUT_QUEUE_B = "fanout_queue_B";

    /**
     * 队列C
     */
    public final static String FANOUT_QUEUE_C = "fanout_queue_C";

    /**
     * 交换机
     */
    public final static String FANOUT_EXCHANGE = "fanout_exchange";

    @Bean
    public Queue fanoutQueueA() {
        return new Queue(FANOUT_QUEUE_A);
    }

    @Bean
    public Queue fanoutQueueB() {
        return new Queue(FANOUT_QUEUE_B);
    }

    @Bean
    public Queue fanoutQueueC() {
        return new Queue(FANOUT_QUEUE_C);
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange(FANOUT_EXCHANGE);
    }

    /**
     * 绑定队列A到交换机
     *
     * @param fanoutQueueA
     * @param fanoutExchange
     * @return
     */
    @Bean
    Binding bindingFanoutQueueA(Queue fanoutQueueA, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueueA).to(fanoutExchange);
    }

    /**
     * 绑定队列B到交换机
     *
     * @param fanoutQueueB
     * @param fanoutExchange
     * @return
     */
    @Bean
    Binding bindingFanoutQueueB(Queue fanoutQueueB, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueueB).to(fanoutExchange);
    }

    /**
     * 绑定队列C到交换机
     *
     * @param fanoutQueueC
     * @param fanoutExchange
     * @return
     */
    @Bean
    Binding bindingFanoutQueueC(Queue fanoutQueueC, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueueC).to(fanoutExchange);
    }

}