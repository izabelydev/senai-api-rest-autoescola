package br.com.senai.autoescola_n321.usecase.validacoes.impl;

import br.com.senai.autoescola_n321.adapter.in.dto.instrucao.DadosAgendamentoInstrucao;
import br.com.senai.autoescola_n321.adapter.out.domain.entity.Instrucao;
import br.com.senai.autoescola_n321.adapter.out.repository.InstrucaoRepository;
import br.com.senai.autoescola_n321.infra.exception.ValidacaoException;
import br.com.senai.autoescola_n321.usecase.validacoes.ValidacoesUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ValidacaoLimiteDiarioAlunoImpl implements ValidacoesUseCase {

    @Autowired
    private InstrucaoRepository instrucaoRepository;

    @Override
    public void validar(DadosAgendamentoInstrucao dados) {
        Instrucao instrucao = instrucaoRepository.findByAlunoIdAndCanceladaFalse();
        Integer diaAgendado = instrucao.getData().getDayOfMonth();
        Integer diaHoje = LocalDateTime.now().getDayOfMonth();

        if(diaAgendado.equals(diaHoje)) {
            throw new ValidacaoException("Não é possível agendar mais de uma instrução no mesmo dia para o mesmo aluno");
        }
    }
}
