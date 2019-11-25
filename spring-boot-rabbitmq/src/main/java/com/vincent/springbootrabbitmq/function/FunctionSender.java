package com.vincent.springbootrabbitmq.function;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class FunctionSender {

    @Autowired
    AmqpTemplate amqpTemplate;


    public void send() {
        amqpTemplate.convertAndSend("fanoutExchange","", "message");
    }
}
