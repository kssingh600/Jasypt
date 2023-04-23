package net.ksacademy.springboot.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import lombok.extern.java.Log;
import net.ksacademy.springboot.dto.User;

@Service
@Log
public class RabbitMQJsonConsumer {
    

    @RabbitListener(queues = {"${rabbitmq.queue.json.name}"})
    public void consumeJsonMessage(User user){
        log.info(String.format("Received JSON message -> %s", user.toString()));
    }

}
