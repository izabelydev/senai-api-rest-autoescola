package br.com.senai.autoescola_n321.application.core.validations.instrucao.cancelamento.impl;

import br.com.senai.autoescola_n321.application.core.domain.model.Instrucao;
import br.com.senai.autoescola_n321.adapter.out.repository.persistence.InstrucaoJpaRepository;
import br.com.senai.autoescola_n321.exception.types.validation.ValidacaoException;
import br.com.senai.autoescola_n321.application.core.validations.instrucao.cancelamento.ValidacoesCancelamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidarAntecedenciaCancelamentoImpl implements ValidacoesCancelamento {

    @Autowired
    private InstrucaoJpaRepository instrucaoJpaRepository;

    @Override
    public void validar(Instrucao instrucao) {
        Long antecedencia = Duration.between(LocalDateTime.now(), instrucao.getData()).toHours();

        if(antecedencia < 24) {
            throw new ValidacaoException("A instrução deve ser cancelada no mínimo 24 horas antes do horário agendado.");
        }
    }
}
