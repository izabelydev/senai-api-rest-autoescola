package br.com.senai.autoescola_n321.application.core.validations.instrucao.agendamento.impl;

import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.instrucao.DadosAgendamentoInstrucao;
import br.com.senai.autoescola_n321.adapter.out.repository.persistence.InstrucaoJpaRepository;
import br.com.senai.autoescola_n321.exception.types.validation.ValidacaoException;
import br.com.senai.autoescola_n321.application.core.validations.instrucao.agendamento.ValidacoesAgendamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ValidacaoLimiteDiarioAlunoImpl implements ValidacoesAgendamento {

    @Autowired
    private InstrucaoJpaRepository instrucaoJpaRepository;

    @Override
    public void validar(DadosAgendamentoInstrucao dados) {
        LocalDateTime dataHoraInicio = dados.data().withHour(6);
        LocalDateTime dataHoraFim = dados.data().withHour(21 - 1);

        Boolean isAgendamentoNaMesmaData = instrucaoJpaRepository.existsByAlunoIdAndDataBetweenAndCanceladaFalse(
          dados.idAluno(), dataHoraInicio, dataHoraFim
        );

        if(isAgendamentoNaMesmaData) {
            throw new ValidacaoException("Não é possível agendar mais de uma instrução no mesmo dia para o mesmo aluno");
        }
    }
}
