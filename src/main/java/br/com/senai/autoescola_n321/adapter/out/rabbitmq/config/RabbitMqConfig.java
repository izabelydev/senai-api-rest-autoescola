package br.com.senai.autoescola_n321.adapter.out.rabbitmq.config;

import br.com.senai.autoescola_n321.application.core.service.EmailNotificationService;
import br.com.senai.autoescola_n321.application.ports.out.EmailPublisher;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMqConfig {

    @Bean
    public Queue emailOcorrenciaQueue() {
        return new Queue("autoescola-n321-email-ocorrencia", true);
    }

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory factory) {
        RabbitTemplate template = new RabbitTemplate(factory);
        template.setMessageConverter(jackson2JsonMessageConverter());
        return template;
    }

    @Bean
    public EmailNotificationService emailNotificationService(EmailPublisher publisher) {
        return new EmailNotificationService(publisher);
    }
}
