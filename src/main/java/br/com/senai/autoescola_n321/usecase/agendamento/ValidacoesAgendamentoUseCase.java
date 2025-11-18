package br.com.senai.autoescola_n321.usecase.agendamento;

import br.com.senai.autoescola_n321.adapter.in.dto.instrucao.DadosAgendamentoInstrucao;

public interface ValidacoesAgendamentoUseCase {
    void validar(DadosAgendamentoInstrucao dados);
}
