package br.com.senai.autoescola_n321.application.ports.out;

import br.com.senai.autoescola_n321.adapter.out.rabbitmq.events.EmailOcorrenciaEvent;

public interface EmailPublisher {
    void publicar(EmailOcorrenciaEvent event);
}
