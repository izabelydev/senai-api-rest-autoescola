package br.com.senai.autoescola_n321.usecase.validacoes;

import br.com.senai.autoescola_n321.adapter.in.dto.instrucao.DadosAgendamentoInstrucao;

public interface ValidacoesUseCase {
    void validar(DadosAgendamentoInstrucao dados);
}
