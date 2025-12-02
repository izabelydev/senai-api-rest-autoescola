package br.com.senai.autoescola_n321.adapter.in.rabbitmq.message;

import java.util.List;

public record EmailMensagem (
        Long idAgenda,
        List<String> emails,
        String assunto,
        String mensagem
){}
