package br.com.senai.autoescola_n321.adapter.out.viacep.mapper;

import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.endereco.DadosEndereco;
import br.com.senai.autoescola_n321.adapter.in.controller.dto.response.viacep.DadosEnderecoViaCep;
import br.com.senai.autoescola_n321.adapter.in.controller.dto.response.viacep.DadosViaCep;
import org.springframework.stereotype.Component;

@Component
public class ViaCepMapper {

    public DadosEnderecoViaCep toResponse(DadosViaCep endereco) {
        return new DadosEnderecoViaCep(
                endereco.cep(),
                endereco.logradouro(),
                endereco.bairro(),
                endereco.localidade(),
                endereco.uf()
        );
    }

    public DadosEndereco toDto(DadosEnderecoViaCep endereco) {
        return new DadosEndereco(
                endereco.logradouro(),
                endereco.bairro(),
                endereco.cidade(),
                endereco.uf(),
               endereco.cep(),
                null,
                null
        );
    }
}
