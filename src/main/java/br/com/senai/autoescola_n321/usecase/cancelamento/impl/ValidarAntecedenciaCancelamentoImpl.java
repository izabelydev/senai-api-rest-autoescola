package br.com.senai.autoescola_n321.usecase.cancelamento.impl;

import br.com.senai.autoescola_n321.adapter.out.domain.entity.Instrucao;
import br.com.senai.autoescola_n321.adapter.out.repository.InstrucaoRepository;
import br.com.senai.autoescola_n321.infra.exception.validation.ValidacaoException;
import br.com.senai.autoescola_n321.usecase.cancelamento.ValidacoesCancelamentoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidarAntecedenciaCancelamentoImpl implements ValidacoesCancelamentoUseCase {

    @Autowired
    private InstrucaoRepository instrucaoRepository;

    @Override
    public void validar(Instrucao instrucao) {
        Long antecedencia = Duration.between(LocalDateTime.now(), instrucao.getData()).toHours();

        if(antecedencia < 24) {
            throw new ValidacaoException("A instrução deve ser cancelada no mínimo 24 horas antes do horário agendado.");
        }
    }
}
