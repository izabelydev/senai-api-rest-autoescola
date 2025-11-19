package br.com.senai.autoescola_n321.adapter.in.controller.mapper;

import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.instrutor.DadosCadastroInstrutor;
import br.com.senai.autoescola_n321.adapter.in.controller.dto.response.instrutor.DadosDetalhamentoInstrutor;
import br.com.senai.autoescola_n321.application.core.domain.model.Instrutor;
import org.springframework.stereotype.Component;

@Component
public class InstrutorMapper {

    public Instrutor toEntity(DadosCadastroInstrutor dados) {
        return new Instrutor(
                null,
                true,
                dados.nome(),
                dados.email(),
                dados.telefone(),
                dados.cnh(),
                dados.especialidade(),
                dados.endereco()
        );
    }

    public DadosDetalhamentoInstrutor toDto(Instrutor dados) {
        return new DadosDetalhamentoInstrutor(
                dados.getId(),
                dados.getAtivo(),
                dados.getNome(),
                dados.getCnh(),
                dados.getEmail(),
                dados.getTelefone(),
                dados.getEspecialidade(),
                dados.getEndereco()
        );
    }
}
