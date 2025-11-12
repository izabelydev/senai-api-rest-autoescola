package br.com.senai.autoescola_n321.usecase.validacoes.impl;

import br.com.senai.autoescola_n321.adapter.in.dto.instrucao.DadosAgendamentoInstrucao;
import br.com.senai.autoescola_n321.infra.exception.ValidacaoException;
import br.com.senai.autoescola_n321.usecase.validacoes.ValidacoesUseCase;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ValidacaoHoraInteiraImpl implements ValidacoesUseCase {

    @Override
    public void validar(DadosAgendamentoInstrucao dados) {
        LocalDateTime dataAgendamento = dados.data();

        if(dataAgendamento.getMinute() != 0) {
            throw new ValidacaoException("O agendamento deve ser em horas pontuais. Ex: 18:00.");
        }
    }
}
