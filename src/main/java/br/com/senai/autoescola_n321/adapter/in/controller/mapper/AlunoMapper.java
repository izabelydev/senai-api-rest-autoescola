package br.com.senai.autoescola_n321.adapter.in.controller.mapper;

import static java.util.Objects.isNull;

import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.aluno.DadosAtualizacaoAluno;
import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.aluno.DadosCadastroAluno;
import br.com.senai.autoescola_n321.adapter.in.controller.dto.response.aluno.DadosListagemAluno;
import br.com.senai.autoescola_n321.application.core.domain.model.Aluno;
import org.springframework.stereotype.Component;

@Component
public class AlunoMapper {

    private final EnderecoAlunoMapper mapper;

    public AlunoMapper(EnderecoAlunoMapper mapper) {
        this.mapper = mapper;
    }

    public Aluno toEntity(DadosCadastroAluno dados) {
        return new Aluno(
                null,
                true,
                dados.nome(),
                dados.cpf(),
                dados.email(),
                dados.telefone(),
                mapper.toEntity(dados.endereco())
        );
    }

    public DadosListagemAluno toDto(Aluno dados) {
        return new DadosListagemAluno(
                dados.getId(),
                dados.getNome(),
                dados.getCpf(),
                dados.getEmail()
        );
    }

    public void atualizarDtoToEntity(DadosAtualizacaoAluno dados, Aluno aluno) {
        if (!isNull(dados.nome())) {
            aluno.setNome(dados.nome());
        }

        if (!isNull(dados.telefone())) {
            aluno.setTelefone(dados.telefone());
        }

        if (!isNull(dados.endereco())) {
            mapper.atualizarVoToEntity(dados.endereco(), aluno.getEndereco());
        }
    }
}
