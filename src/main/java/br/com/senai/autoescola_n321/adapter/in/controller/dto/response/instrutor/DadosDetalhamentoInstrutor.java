package br.com.senai.autoescola_n321.adapter.in.controller.dto.response.instrutor;

import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.endereco.DadosEndereco;
import br.com.senai.autoescola_n321.application.core.domain.enums.Especialidade;

public record DadosDetalhamentoInstrutor (
    Long id,
    Boolean ativo,
    String nome,
    String cnh,
    String email,
    String telefone,
    Especialidade especialidade,
    DadosEndereco endereco
) {}
