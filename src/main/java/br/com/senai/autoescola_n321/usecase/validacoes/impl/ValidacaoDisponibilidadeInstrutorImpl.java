package br.com.senai.autoescola_n321.usecase.validacoes.impl;

import br.com.senai.autoescola_n321.adapter.in.dto.instrucao.DadosAgendamentoInstrucao;
import br.com.senai.autoescola_n321.adapter.out.repository.InstrucaoRepository;
import br.com.senai.autoescola_n321.infra.exception.ValidacaoException;
import br.com.senai.autoescola_n321.usecase.validacoes.ValidacoesUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoDisponibilidadeInstrutorImpl implements ValidacoesUseCase {

    @Autowired
    private InstrucaoRepository instrucaoRepository;

    @Override
    public void validar(DadosAgendamentoInstrucao dados) {
        Boolean isInstrutorOcupado = instrucaoRepository.existsByInstrutorIdAndDataAndCanceladaFalse(
                dados.idInstrutor(), dados.data()
        );

        if(isInstrutorOcupado) {
            throw new ValidacaoException("O instrutor selecionado não está disponível no horário: "
                                         + dados.data().toString());
        }
    }
}
