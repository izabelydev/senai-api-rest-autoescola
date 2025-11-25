package br.com.senai.autoescola_n321.adapter.in.controller.mapper;

import static java.util.Objects.isNull;

import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.aluno.DadosAtualizacaoAluno;
import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.aluno.DadosCadastroAluno;
import br.com.senai.autoescola_n321.adapter.in.controller.dto.response.aluno.DadosDetalhamentoAluno;
import br.com.senai.autoescola_n321.adapter.in.controller.dto.response.aluno.DadosListagemAluno;
import br.com.senai.autoescola_n321.adapter.out.repository.entity.AlunoEntity;
import org.springframework.stereotype.Component;

@Component
public class AlunoMapper {

    private final EnderecoAlunoMapper mapper;

    public AlunoMapper(EnderecoAlunoMapper mapper) {
        this.mapper = mapper;
    }

    public AlunoEntity toEntity(DadosCadastroAluno dados) {
        return new AlunoEntity (
                null,
                true,
                dados.nome(),
                dados.cpf(),
                dados.email(),
                dados.telefone(),
                mapper.toEntity(dados.endereco())
        );
    }

    public DadosDetalhamentoAluno toDetailsDto(AlunoEntity dados) {
        return new DadosDetalhamentoAluno(
                dados.getId(),
                dados.getAtivo(),
                dados.getNome(),
                dados.getEmail(),
                dados.getTelefone(),
                dados.getCpf(),
                mapper.toDto(dados.getEndereco())
        );
    }

    public DadosListagemAluno toListDto(AlunoEntity entity) {
        return new DadosListagemAluno(
                entity.getId(),
                entity.getNome(),
                entity.getCpf(),
                entity.getEmail()
        );
    }

    public void atualizarDtoToEntity(DadosAtualizacaoAluno dados, AlunoEntity aluno) {
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
