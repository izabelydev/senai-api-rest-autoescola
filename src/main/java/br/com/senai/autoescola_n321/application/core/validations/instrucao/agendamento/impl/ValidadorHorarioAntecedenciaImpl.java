package br.com.senai.autoescola_n321.application.core.validations.instrucao.agendamento.impl;

import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.instrucao.DadosAgendamentoInstrucao;
import br.com.senai.autoescola_n321.exception.types.validation.ValidacaoException;
import br.com.senai.autoescola_n321.application.core.validations.instrucao.agendamento.ValidacoesAgendamento;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioAntecedenciaImpl implements ValidacoesAgendamento {

    @Override
    public void validar(DadosAgendamentoInstrucao dados) {

        LocalDateTime dataAgendamento = dados.data();
        LocalDateTime horaAgora = LocalDateTime.now();

        Long antecedencia = Duration.between(horaAgora, dataAgendamento).toMinutes();

        if(antecedencia < 30) {
            throw new ValidacaoException("O agendamento deve ter no mínimo 30 minutos de antecedência.");
        }
    }
}
