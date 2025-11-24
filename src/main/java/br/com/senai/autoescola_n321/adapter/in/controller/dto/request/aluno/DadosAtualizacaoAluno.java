package br.com.senai.autoescola_n321.adapter.in.controller.dto.request.aluno;

import br.com.senai.autoescola_n321.application.core.domain.enums.Especialidade;
import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoAluno(

		@NotNull
		Long id,
		String nome,
		String telefone,
		Especialidade especialidade,

		@Valid
		DadosEndereco endereco
) {}