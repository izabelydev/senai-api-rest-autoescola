package br.com.senai.autoescola_n321.adapter.in.controller.dto.response.instrucao;

import br.com.senai.autoescola_n321.application.core.domain.enums.MotivoCancelamento;
import br.com.senai.autoescola_n321.application.core.domain.model.Instrucao;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record DadosDetalhamentoCancelamento(
        Long id,

        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime dataCancelamento,

        MotivoCancelamento motivoCancelamento
) {
    public DadosDetalhamentoCancelamento(Instrucao instrucao) {
        this(
                instrucao.getId(),
                instrucao.getDataCancelamento(),
                instrucao.getMotivo()
        );
    }
}
