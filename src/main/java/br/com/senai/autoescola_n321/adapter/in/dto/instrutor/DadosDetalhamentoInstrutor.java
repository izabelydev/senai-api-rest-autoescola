package br.com.senai.autoescola_n321.adapter.in.dto.instrutor;

import br.com.senai.autoescola_n321.adapter.in.dto.instrutor.enums.Especialidade;
import br.com.senai.autoescola_n321.adapter.out.domain.entity.Instrutor;
import br.com.senai.autoescola_n321.adapter.out.domain.valueobject.EnderecoInstrutor;

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
