package br.com.senai.autoescola_n321.application.core.service;

import br.com.senai.autoescola_n321.application.core.domain.model.Instrucao;
import br.com.senai.autoescola_n321.application.ports.out.EmailPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailNotificationService {
    private final EmailPublisher publisher;

    public EmailNotificationService(EmailPublisher publisher) {
        this.publisher = publisher;
    }

    public void enviarNotificacao(Instrucao instrucao, AcaoEmailEnum acao) {
        List<String> emails = List.of(
                instrucao.getAluno().getEmail(),
                instrucao.getInstrutor().getEmail()
        );

        String assunto = acao.name() + " DE INSTRUÇÃO.";
        String mensagem =
                "\nUma instrução foi " + acao.getDescricao()
                + "\nAluno: "
                + "\n     Nome: " + instrucao.getAluno().getNome()
                + "\n     ID: " + instrucao.getAluno().getId()

                + "\nInstrutor: "
                + "\n     Nome: " + instrucao.getInstrutor().getNome()
                + "\n     ID: " + instrucao.getInstrutor().getId();
    }
}
