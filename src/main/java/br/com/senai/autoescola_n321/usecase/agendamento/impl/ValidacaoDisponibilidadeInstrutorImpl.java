package br.com.senai.autoescola_n321.usecase.agendamento.impl;

import br.com.senai.autoescola_n321.adapter.in.dto.instrucao.DadosAgendamentoInstrucao;
import br.com.senai.autoescola_n321.adapter.out.repository.InstrucaoRepository;
import br.com.senai.autoescola_n321.infra.exception.validation.ValidacaoException;
import br.com.senai.autoescola_n321.usecase.agendamento.ValidacoesAgendamentoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoDisponibilidadeInstrutorImpl implements ValidacoesAgendamentoUseCase {

    @Autowired
    private InstrucaoRepository instrucaoRepository;

    @Override
    public void validar(DadosAgendamentoInstrucao dados) {
        Boolean isInstrutorOcupado = instrucaoRepository.existsByInstrutorIdAndDataAndCanceladaFalse(
                dados.idInstrutor(), dados.data()
        );

        if(isInstrutorOcupado) {
            throw new ValidacaoException("O instrutor selecionado não está disponível no horário: "
                                         + dados.data().toString());
        }
    }
}
