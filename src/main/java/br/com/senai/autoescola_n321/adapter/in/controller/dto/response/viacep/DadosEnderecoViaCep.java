package br.com.senai.autoescola_n321.adapter.in.controller.dto.response.viacep;

public record DadosEnderecoViaCep(
        String cep,
        String logradouro,
        String bairro,
        String cidade,
        String uf
) {}
