package br.com.senai.autoescola_n321.application.core.validations.instrucao.agendamento.impl;

import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.instrucao.DadosAgendamentoInstrucao;
import br.com.senai.autoescola_n321.exception.types.validation.ValidacaoException;
import br.com.senai.autoescola_n321.application.core.validations.instrucao.agendamento.ValidacoesAgendamento;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ValidacaoHoraInteiraImpl implements ValidacoesAgendamento {

    @Override
    public void validar(DadosAgendamentoInstrucao dados) {
        LocalDateTime dataAgendamento = dados.data();

        if(dataAgendamento.getMinute() != 0) {
            throw new ValidacaoException("O agendamento deve ser em horas pontuais. Ex: 18:00.");
        }
    }
}
