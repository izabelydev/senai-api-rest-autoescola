package br.com.senai.autoescola_n321.adapter.out.repository.mapper;

import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.instrucao.DadosAgendamentoInstrucao;
import br.com.senai.autoescola_n321.adapter.out.repository.entity.AlunoEntity;
import br.com.senai.autoescola_n321.adapter.out.repository.entity.InstrucaoEntity;
import br.com.senai.autoescola_n321.adapter.out.repository.entity.InstrutorEntity;
import br.com.senai.autoescola_n321.application.core.domain.model.Instrucao;
import org.springframework.stereotype.Component;

@Component
public class InstrucaoEntityMapper {

    public InstrucaoEntity dtoToEntity(DadosAgendamentoInstrucao dados, AlunoEntity aluno, InstrutorEntity instrutor) {
        return new InstrucaoEntity (
                null,
                dados.data(),
                null,
                false,
                null,
                aluno,
                instrutor
        );
    }

    public InstrucaoEntity toEntity(Instrucao domain) {
        return new InstrucaoEntity (
                domain.getId(),
                domain.getData(),
                domain.getDataCancelamento(),
                domain.getCancelada(),
                domain.getMotivo(),
                domain.getAluno(),
                domain.getInstrutor()
        );
    }

    public Instrucao toDomain(InstrucaoEntity entity) {
        return new Instrucao (
                entity.getId(),
                entity.getData(),
                entity.getDataCancelamento(),
                entity.getCancelada(),
                entity.getMotivo(),
                entity.getAluno(),
                entity.getInstrutor()
        );
    }
}
