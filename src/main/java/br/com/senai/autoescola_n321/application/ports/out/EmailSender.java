package br.com.senai.autoescola_n321.application.ports.out;

public interface EmailSender {
    void enviar(String destinatario, String assunto, String conteudo);
}
