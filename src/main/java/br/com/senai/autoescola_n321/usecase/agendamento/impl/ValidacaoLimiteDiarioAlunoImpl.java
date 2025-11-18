package br.com.senai.autoescola_n321.usecase.agendamento.impl;

import br.com.senai.autoescola_n321.adapter.in.dto.instrucao.DadosAgendamentoInstrucao;
import br.com.senai.autoescola_n321.adapter.out.repository.InstrucaoRepository;
import br.com.senai.autoescola_n321.infra.exception.validation.ValidacaoException;
import br.com.senai.autoescola_n321.usecase.agendamento.ValidacoesAgendamentoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ValidacaoLimiteDiarioAlunoImpl implements ValidacoesAgendamentoUseCase {

    @Autowired
    private InstrucaoRepository instrucaoRepository;

    @Override
    public void validar(DadosAgendamentoInstrucao dados) {
        LocalDateTime dataHoraInicio = dados.data().withHour(6);
        LocalDateTime dataHoraFim = dados.data().withHour(21 - 1);

        Boolean isAgendamentoNaMesmaData = instrucaoRepository.existsByAlunoIdAndDataBetweenAndCanceladaFalse(
          dados.idAluno(), dataHoraInicio, dataHoraFim
        );

        if(isAgendamentoNaMesmaData) {
            throw new ValidacaoException("Não é possível agendar mais de uma instrução no mesmo dia para o mesmo aluno");
        }
    }
}
