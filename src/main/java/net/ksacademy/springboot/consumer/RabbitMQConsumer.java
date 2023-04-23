package net.ksacademy.springboot.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import lombok.extern.java.Log;

@Service
@Log
public class RabbitMQConsumer {

    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void consume(String message){
        log.info(String.format("Recieved message -> %s", message));
    }
}
 