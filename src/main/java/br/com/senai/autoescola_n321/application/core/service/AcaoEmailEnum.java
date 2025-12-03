package br.com.senai.autoescola_n321.application.core.service;

public enum AcaoEmailEnum {
    AGENDAMENTO("AGENDADA"),
    CANCELAMENTO("CANCELADA");

    private final String descricao;

    AcaoEmailEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
