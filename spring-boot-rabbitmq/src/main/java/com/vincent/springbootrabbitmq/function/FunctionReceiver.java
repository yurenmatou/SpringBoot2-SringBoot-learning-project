package com.vincent.springbootrabbitmq.function;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "function.A")
public class FunctionReceiver {


    @RabbitHandler
    public void process(String message) {
        System.out.println("555555555555555" + message);
    }
}
