package br.com.senai.autoescola_n321.application.core.validations.instrucao.agendamento.impl;

import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.instrucao.DadosAgendamentoInstrucao;
import br.com.senai.autoescola_n321.adapter.out.repository.persistence.InstrucaoRepository;
import br.com.senai.autoescola_n321.exception.types.validation.ValidacaoException;
import br.com.senai.autoescola_n321.application.core.validations.instrucao.agendamento.ValidacoesAgendamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoDisponibilidadeInstrutorImpl implements ValidacoesAgendamento {

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
