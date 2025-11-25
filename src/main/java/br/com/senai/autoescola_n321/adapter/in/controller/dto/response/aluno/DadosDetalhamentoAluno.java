package br.com.senai.autoescola_n321.adapter.in.controller.dto.response.aluno;

import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.endereco.DadosEndereco;


public record DadosDetalhamentoAluno(
        Long id,
        Boolean ativo,
        String nome,
        String email,
        String telefone,
        String cpf,
        DadosEndereco endereco
) {}
