package br.com.senai.autoescola_n321.application.ports.out;

import br.com.senai.autoescola_n321.adapter.in.controller.dto.response.viacep.DadosEnderecoViaCep;

public interface ViaCepPort {
    DadosEnderecoViaCep buscarEnderecoPorCep(String cep);
}
