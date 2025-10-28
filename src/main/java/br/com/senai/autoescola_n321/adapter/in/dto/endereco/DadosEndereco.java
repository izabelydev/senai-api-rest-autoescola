package br.com.senai.autoescola_n321.adapter.in.dto.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(

		@NotBlank
		String logradouro,

		@NotBlank
		String bairro,

		@NotBlank
		@Pattern(regexp = "[A-Z]{2}")
		String uf,

		@NotBlank
		String cidade,

		@NotBlank
		@Pattern(regexp = "\\d{8}")
		String cep,

		String complemento,
		String numero
) {}