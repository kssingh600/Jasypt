package net.ksacademy.springboot.publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.extern.java.Log;
import net.ksacademy.springboot.dto.User;

@Service
@Log
public class RabbitMQJsonProducer {

    @Value("${rabbitmq.exchange.name}")
    private String exchange ;
    
    @Value("${rabbitmq.routing.json.key}")
    private String routingJsonKey ;

    private RabbitTemplate rabbitTemplate ;

    public RabbitMQJsonProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendJsonMessage(User user){
        log.info(String.format("Json message sent -> %s", user.toString()));
        rabbitTemplate.convertAndSend(exchange, routingJsonKey, user);
    }
    
}
