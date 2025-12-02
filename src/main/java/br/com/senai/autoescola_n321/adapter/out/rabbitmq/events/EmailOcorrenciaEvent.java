package br.com.senai.autoescola_n321.adapter.out.rabbitmq.events;

import java.io.Serializable;
import java.util.List;

public record EmailOcorrenciaEvent(
        Long idAgenda,
        List<String> emails,
        String assunto,
        String mensagem
) implements Serializable {}
