package br.com.senai.autoescola_n321.adapter.in.dto.instrutor;

import br.com.senai.autoescola_n321.adapter.in.dto.endereco.DadosEndereco;
import br.com.senai.autoescola_n321.adapter.in.dto.instrutor.enums.Especialidade;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoInstrutor(

		@NotNull
		Long id,
		String nome,
		String telefone,
		Especialidade especialidade,

		@Valid
		DadosEndereco endereco
) {}