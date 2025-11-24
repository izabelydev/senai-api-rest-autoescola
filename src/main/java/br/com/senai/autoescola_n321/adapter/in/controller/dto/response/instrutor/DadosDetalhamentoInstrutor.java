package br.com.senai.autoescola_n321.adapter.in.controller.dto.response.instrutor;

import br.com.senai.autoescola_n321.application.core.domain.enums.Especialidade;
import br.com.senai.autoescola_n321.application.core.domain.model.Instrutor;
import br.com.senai.autoescola_n321.application.core.domain.vo.EnderecoInstrutor;

public record DadosDetalhamentoInstrutor (
    Long id,
    Boolean ativo,
    String nome,
    String cnh,
    String email,
    String telefone,
    Especialidade especialidade,
    EnderecoInstrutor endereco
) {
	public DadosDetalhamentoInstrutor(Instrutor instrutor) {
            this(
                    instrutor.getId(),
                    instrutor.getAtivo(),
                    instrutor.getNome(),
                    instrutor.getCnh(),
                    instrutor.getEmail(),
                    instrutor.getTelefone(),
                    instrutor.getEspecialidade(),
                    instrutor.getEndereco()
            );
        }
    }
