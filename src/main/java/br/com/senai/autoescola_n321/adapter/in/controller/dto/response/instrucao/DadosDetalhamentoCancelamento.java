package br.com.senai.autoescola_n321.adapter.in.controller.dto.response.instrucao;

import br.com.senai.autoescola_n321.adapter.out.repository.entity.InstrucaoEntity;
import br.com.senai.autoescola_n321.application.core.domain.enums.MotivoCancelamento;

import java.time.LocalDateTime;

public record DadosDetalhamentoCancelamento(
        Long id,
        LocalDateTime dataCancelamento,
        MotivoCancelamento motivoCancelamento
) {
    public DadosDetalhamentoCancelamento(InstrucaoEntity instrucao) {
        this(
                instrucao.getId(),
                instrucao.getDataCancelamento(),
                instrucao.getMotivo()
        );
    }
}
