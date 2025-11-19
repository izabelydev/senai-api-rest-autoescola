package br.com.senai.autoescola_n321.adapter.in.controller.dto.request.aluno;

import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroAluno(

		@NotBlank
		String nome,

		@NotBlank
		@Pattern(regexp = "^\\d{3}\\.?\\d{3}\\.?\\d{3}-?\\d{2}$")
		String cpf,

		@Email
		@NotBlank
		String email,

		@NotBlank
		String telefone,

		@Valid
		@NotNull
		DadosEndereco endereco
) {}