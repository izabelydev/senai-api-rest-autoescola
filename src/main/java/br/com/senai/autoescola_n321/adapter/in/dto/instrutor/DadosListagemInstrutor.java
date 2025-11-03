package br.com.senai.autoescola_n321.adapter.in.dto.instrutor;

import br.com.senai.autoescola_n321.adapter.in.dto.instrutor.enums.Especialidade;
import br.com.senai.autoescola_n321.adapter.out.domain.entity.Instrutor;


public record DadosListagemInstrutor(
		Long id,
		String nome,
		String cnh,
		String email,
		Especialidade especialidade
) {
	public DadosListagemInstrutor(Instrutor instrutor) {
		this(
				instrutor.getId(),
				instrutor.getNome(),
				instrutor.getCnh(),
				instrutor.getEmail(),
				instrutor.getEspecialidade()
		);
	}
}