package br.com.senai.autoescola_n321.entity.instrutor;

import br.com.senai.autoescola_n321.entity.endereco.DadosEndereco;
import br.com.senai.autoescola_n321.entity.instrutor.enums.Especialidade;
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

		@NotNull
		Especialidade especialidade,

		@Valid
		@NotNull
		DadosEndereco endereco
) {}