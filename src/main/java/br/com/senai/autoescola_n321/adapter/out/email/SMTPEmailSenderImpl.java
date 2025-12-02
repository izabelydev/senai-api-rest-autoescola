package br.com.senai.autoescola_n321.adapter.out.email;

import br.com.senai.autoescola_n321.application.ports.out.EmailSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SMTPEmailSenderImpl implements EmailSender {

    private final JavaMailSender mailSender;

    public SMTPEmailSenderImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void enviar(String destinatario, String assunto, String conteudo) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(destinatario);
            message.setSubject(assunto);
            message.setText(conteudo);
            mailSender.send(message);
        } catch (Exception e) {
            log.error("Erro ao enviar e-mail para {} - {}", destinatario, e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
