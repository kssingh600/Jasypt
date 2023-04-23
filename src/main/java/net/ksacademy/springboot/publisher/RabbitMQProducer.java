package net.ksacademy.springboot.publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RabbitMQProducer {

    @Value("${rabbitmq.exchange.name}")
    private String exchange ;

    @Value("${rabbitmq.routing.key}")
    private String routingKey ;

    //spring boot automatically configures RabbitTemplate for us; we just have to inject and use it
    private RabbitTemplate rabbitTemplate ;

    //if spring bean has only one parameterized constructor, we can omit the @Autowired
    public RabbitMQProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate ;
    }

    public void sendMessage(String message){
        log.info(String.format("Message sent -> %s", message));
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
        // try{
        //     rabbitTemplate.convertAndSend(exchange, routingKey, message);
        // }
        // catch(Exception e){
        //     log.error("Error occured while establishing connection:  >>>>>", e);
        // }
    } 
}
