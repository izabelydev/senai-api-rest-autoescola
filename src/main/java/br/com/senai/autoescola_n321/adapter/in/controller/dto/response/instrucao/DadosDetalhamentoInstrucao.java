package br.com.senai.autoescola_n321.adapter.in.controller.dto.response.instrucao;

import br.com.senai.autoescola_n321.adapter.out.repository.entity.InstrucaoEntity;
import br.com.senai.autoescola_n321.application.core.domain.enums.Especialidade;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record DadosDetalhamentoInstrucao(
        Long id,
        String nomeAluno,
        String nomeInstrutor,
        Especialidade especialidade,
        Boolean cancelada,

        @JsonFormat(pattern = "dd/mm/yyyy HH:mm")
        LocalDateTime data
) {
    public DadosDetalhamentoInstrucao(InstrucaoEntity instrucao) {
        this(
                instrucao.getId(),
                instrucao.getAluno().getNome(),
                instrucao.getInstrutor().getNome(),
                instrucao.getInstrutor().getEspecialidade(),
                instrucao.getCancelada(),
                instrucao.getData()
        );
    }
}
