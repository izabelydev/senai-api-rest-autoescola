package br.com.senai.autoescola_n321.adapter.out.repository.mapper;

import br.com.senai.autoescola_n321.adapter.out.repository.entity.InstrutorEntity;
import br.com.senai.autoescola_n321.application.core.domain.model.Instrutor;
import org.springframework.stereotype.Component;

@Component
public class InstrutorEntityMapper {

    public InstrutorEntity toEntity(Instrutor domain) {
        return new InstrutorEntity (
                domain.getId(),
                domain.getAtivo(),
                domain.getNome(),
                domain.getEmail(),
                domain.getTelefone(),
                domain.getCnh(),
                domain.getEspecialidade(),
                domain.getEndereco()
        );
    }

    public Instrutor toDomain(InstrutorEntity domain) {
        return new Instrutor (
                domain.getId(),
                domain.getAtivo(),
                domain.getNome(),
                domain.getEmail(),
                domain.getTelefone(),
                domain.getCnh(),
                domain.getEspecialidade(),
                domain.getEndereco()
        );
    }
}
