package br.com.senai.autoescola_n321.adapter.in.controller.mapper;

import static java.util.Objects.isNull;

import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.instrutor.DadosAtualizacaoInstrutor;
import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.instrutor.DadosCadastroInstrutor;
import br.com.senai.autoescola_n321.adapter.in.controller.dto.response.instrutor.DadosDetalhamentoInstrutor;
import br.com.senai.autoescola_n321.adapter.in.controller.dto.response.instrutor.DadosListagemInstrutor;
import br.com.senai.autoescola_n321.adapter.out.repository.entity.InstrutorEntity;
import br.com.senai.autoescola_n321.application.core.domain.model.Instrutor;
import org.springframework.stereotype.Component;

@Component
public class InstrutorMapper {

    private final EnderecoInstrutorMapper mapper;

    public InstrutorMapper(EnderecoInstrutorMapper mapper) {
        this.mapper = mapper;
    }


    public InstrutorEntity toEntity(DadosCadastroInstrutor dados) {
        return new InstrutorEntity (
                null,
                true,
                dados.nome(),
                dados.email(),
                dados.telefone(),
                dados.cnh(),
                dados.especialidade(),
                mapper.toEntity(dados.endereco())
        );
    }

    public InstrutorEntity domainToEntity(Instrutor dados) {
        return new InstrutorEntity (
                dados.getId(),
                dados.getAtivo(),
                dados.getNome(),
                dados.getEmail(),
                dados.getTelefone(),
                dados.getCnh(),
                dados.getEspecialidade(),
                dados.getEndereco()
        );
    }

    public DadosDetalhamentoInstrutor toDetailsDto(InstrutorEntity dados) {
        return new DadosDetalhamentoInstrutor(
                dados.getId(),
                dados.getAtivo(),
                dados.getNome(),
                dados.getCnh(),
                dados.getEmail(),
                dados.getTelefone(),
                dados.getEspecialidade(),
                mapper.toDto(dados.getEndereco())
        );
    }

    public DadosListagemInstrutor toListDto(Instrutor dados) {
        return new DadosListagemInstrutor(
                dados.getId(),
                dados.getNome(),
                dados.getCnh(),
                dados.getEmail(),
                dados.getEspecialidade()
        );
    }

    public void atualizarDtoToEntity(DadosAtualizacaoInstrutor dados, InstrutorEntity instrutor) {
        if (!isNull(dados.nome())) {
            instrutor.setNome(dados.nome());
        }

        if (!isNull(dados.telefone())) {
            instrutor.setTelefone(dados.telefone());
        }

        if (!isNull(dados.especialidade())) {
            instrutor.setEspecialidade(dados.especialidade());
        }

        if (!isNull(dados.endereco())) {
            mapper.atualizarVoToEntity(dados.endereco(), instrutor.getEndereco());
        }
    }
}
