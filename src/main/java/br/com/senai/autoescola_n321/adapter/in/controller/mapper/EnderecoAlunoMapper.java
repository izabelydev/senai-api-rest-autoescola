package br.com.senai.autoescola_n321.adapter.in.controller.mapper;

import static java.util.Objects.isNull;

import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.endereco.DadosEndereco;
import br.com.senai.autoescola_n321.application.core.domain.vo.EnderecoAluno;
import org.springframework.stereotype.Component;

@Component
public class EnderecoAlunoMapper {

    public EnderecoAluno toEntity(DadosEndereco dados) {
        return new EnderecoAluno(
                dados.logradouro(),
                dados.bairro(),
                dados.uf(),
                dados.cidade(),
                dados.cep(),
                dados.complemento(),
                dados.numero()
        );
    }

    public DadosEndereco toDto(EnderecoAluno dados) {
        return new DadosEndereco(
                dados.getLogradouro(),
                dados.getBairro(),
                dados.getUf(),
                dados.getCidade(),
                dados.getCep(),
                dados.getComplemento(),
                dados.getNumero()
        );
    }

    public void atualizarVoToEntity(DadosEndereco dados, EnderecoAluno endereco) {
        if(!isNull(dados.logradouro())) {
            endereco.setLogradouro(dados.logradouro());
        }

        if(!isNull(dados.numero())) {
            endereco.setNumero(dados.numero());
        }

        if(!isNull(dados.complemento())) {
            endereco.setComplemento(dados.complemento());
        }

        if(!isNull(dados.bairro())) {
            endereco.setBairro(dados.bairro());
        }

        if(!isNull(dados.cidade())) {
            endereco.setCidade(dados.cidade());
        }

        if(!isNull(dados.uf())) {
            endereco.setUf(dados.uf());
        }

        if(!isNull(dados.cep())) {
            endereco.setUf(dados.cep());
        }
    }
}
