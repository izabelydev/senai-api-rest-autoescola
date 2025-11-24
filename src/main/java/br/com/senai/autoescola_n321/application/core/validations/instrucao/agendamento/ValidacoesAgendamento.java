package br.com.senai.autoescola_n321.application.core.validations.instrucao.agendamento;

import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.instrucao.DadosAgendamentoInstrucao;

public interface ValidacoesAgendamento {
    void validar(DadosAgendamentoInstrucao dados);
}
