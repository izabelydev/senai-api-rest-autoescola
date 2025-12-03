package br.com.senai.autoescola_n321.adapter.in.rabbitmq.mapper;

import br.com.senai.autoescola_n321.adapter.in.rabbitmq.message.EmailMensagem;
import br.com.senai.autoescola_n321.adapter.out.rabbitmq.events.EmailOcorrenciaEvent;
import org.springframework.stereotype.Component;

@Component
public class EmailMapper {

    public EmailOcorrenciaEvent toDomain(EmailMensagem emailMsg) {
        return new EmailOcorrenciaEvent(
                emailMsg.idAgenda(),
                emailMsg.emails(),
                emailMsg.assunto(),
                emailMsg.mensagem()
        );
    }
}
