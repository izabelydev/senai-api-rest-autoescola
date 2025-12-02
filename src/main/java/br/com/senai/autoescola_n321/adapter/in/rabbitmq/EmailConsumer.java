package br.com.senai.autoescola_n321.adapter.in.rabbitmq;

import br.com.senai.autoescola_n321.adapter.in.rabbitmq.mapper.EmailMapper;
import br.com.senai.autoescola_n321.adapter.in.rabbitmq.message.EmailMensagem;
import br.com.senai.autoescola_n321.adapter.out.rabbitmq.events.EmailOcorrenciaEvent;
import br.com.senai.autoescola_n321.application.ports.out.EmailSender;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    private final EmailMapper emailMapper;
    private final EmailSender emailSender;

    public EmailConsumer(EmailMapper emailMapper, EmailSender emailSender) {
        this.emailMapper = emailMapper;
        this.emailSender = emailSender;
    }

    @RabbitListener(queues = "autoescola-n321-email-ocorrencia") //TODO colocar a informacao no properties
    public void receberMensagem(EmailMensagem mensagem) {
        EmailOcorrenciaEvent event = emailMapper.toDomain(mensagem);

        event.emails().forEach(email -> {
            emailSender.enviar(email, event.assunto(), event.mensagem());
        });
    }
}
