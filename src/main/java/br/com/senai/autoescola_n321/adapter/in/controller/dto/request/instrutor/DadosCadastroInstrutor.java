package br.com.senai.autoescola_n321.adapter.in.controller.dto.request.instrutor;

import br.com.senai.autoescola_n321.application.core.domain.enums.Especialidade;
import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroInstrutor(

		@NotBlank
		String nome,

		@NotBlank
		@Pattern(regexp = "\\d{9,11}")
		String cnh,

		@Email
		@NotBlank
		String email,

		@NotBlank
		String telefone,

		@NotNull
		Especialidade especialidade,

		@Valid
		@NotNull
		DadosEndereco endereco
) {}