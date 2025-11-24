package br.com.senai.autoescola_n321.application.core.validations.instrucao.agendamento.impl;

import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.instrucao.DadosAgendamentoInstrucao;
import br.com.senai.autoescola_n321.exception.types.validation.ValidacaoException;
import br.com.senai.autoescola_n321.application.core.validations.instrucao.agendamento.ValidacoesAgendamento;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@Component
public class ValidacaoHorarioFuncionamentoImpl implements ValidacoesAgendamento {

    @Override
    public void validar(DadosAgendamentoInstrucao dados) {
        LocalDateTime dataAgendamento = dados.data();

        Boolean isDomingo = dataAgendamento.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        Boolean isPreAbertura = dataAgendamento.getHour() < 6;
        Boolean isPosFechamento = dataAgendamento.getHour() > (21 -1);

        if(isDomingo || isPreAbertura || isPosFechamento ) {
            throw new ValidacaoException("Agendamento fora do horário de funcionamento");
        }
    }
}
