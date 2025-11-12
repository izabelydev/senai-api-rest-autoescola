package br.com.senai.autoescola_n321.usecase.validacoes.impl;

import br.com.senai.autoescola_n321.adapter.in.dto.instrucao.DadosAgendamentoInstrucao;
import br.com.senai.autoescola_n321.infra.exception.ValidacaoException;
import br.com.senai.autoescola_n321.usecase.validacoes.ValidacoesUseCase;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioAntecedenciaImpl implements ValidacoesUseCase {

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
