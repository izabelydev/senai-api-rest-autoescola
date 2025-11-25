package br.com.senai.autoescola_n321.adapter.in.controller.dto.response.instrutor;

import br.com.senai.autoescola_n321.application.core.domain.enums.Especialidade;
import br.com.senai.autoescola_n321.application.core.domain.model.Instrutor;

public record DadosListagemInstrutor(
		Long id,
		String nome,
		String cnh,
		String email,
		Especialidade especialidade
) {}
