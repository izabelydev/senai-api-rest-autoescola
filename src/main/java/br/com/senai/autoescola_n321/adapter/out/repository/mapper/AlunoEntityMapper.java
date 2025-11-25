package br.com.senai.autoescola_n321.adapter.out.repository.mapper;

import br.com.senai.autoescola_n321.adapter.out.repository.entity.AlunoEntity;
import br.com.senai.autoescola_n321.application.core.domain.model.Aluno;
import org.springframework.stereotype.Component;

@Component
public class AlunoEntityMapper {

    public Aluno toDomain(AlunoEntity domain) {
        return new Aluno(
                domain.getId(),
                domain.getAtivo(),
                domain.getNome(),
                domain.getEmail(),
                domain.getTelefone(),
                domain.getCpf(),
                domain.getEndereco()
        );
    }

    public AlunoEntity toEntity(Aluno entity) {
        return new AlunoEntity(
                entity.getId(),
                entity.getAtivo(),
                entity.getNome(),
                entity.getEmail(),
                entity.getTelefone(),
                entity.getCpf(),
                entity.getEndereco()
        );
    }
}
