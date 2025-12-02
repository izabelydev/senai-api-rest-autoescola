package br.com.senai.autoescola_n321.adapter.out.rabbitmq;

import br.com.senai.autoescola_n321.adapter.out.rabbitmq.events.EmailOcorrenciaEvent;
import br.com.senai.autoescola_n321.application.ports.out.EmailPublisher;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class EmailPublisherImpl implements EmailPublisher {

    private final RabbitTemplate template;

    public EmailPublisherImpl(RabbitTemplate template) {
        this.template = template;
    }

    @Override
    public void publicar(EmailOcorrenciaEvent event) {
        template.convertAndSend("autoescola-n321-email-ocorrencia", event);
    }
}
