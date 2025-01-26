package com.system.sales.configs;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String POS_EXCHANGE = "pos.exchange";
    public static final String SALES_QUEUE = "sales.queue";
    public static final String PAYMENT_QUEUE = "payment.queue";
    public static final String STOCK_QUEUE = "stock.queue";

    @Bean
    public DirectExchange posExchange() {
        return new DirectExchange(POS_EXCHANGE);
    }

    @Bean
    public Queue salesQueue() {
        return new Queue(SALES_QUEUE);
    }

    @Bean
    public Queue paymentQueue() {
        return new Queue(PAYMENT_QUEUE);
    }

    @Bean
    public Queue stockQueue() {
        return new Queue(STOCK_QUEUE);
    }

    @Bean
    public Binding salesBinding(DirectExchange posExchange, Queue salesQueue) {
        return BindingBuilder.bind(salesQueue).to(posExchange).with("sales");
    }

    @Bean
    public Binding paymentBinding(DirectExchange posExchange, Queue paymentQueue) {
        return BindingBuilder.bind(paymentQueue).to(posExchange).with("payment");
    }

    @Bean
    public Binding stockBinding(DirectExchange posExchange, Queue stockQueue) {
        return BindingBuilder.bind(stockQueue).to(posExchange).with("stock");
    }
}
