package br.com.senai.autoescola_n321.adapter.in.controller.dto.response.aluno;

import br.com.senai.autoescola_n321.adapter.out.repository.entity.AlunoEntity;
import br.com.senai.autoescola_n321.application.core.domain.model.Aluno;

public record DadosListagemAluno(
		Long id,
		String nome,
		String cpf,
		String email
) {
	public DadosListagemAluno(AlunoEntity aluno) {
		this(
				aluno.getId(),
				aluno.getNome(),
				aluno.getCpf(),
				aluno.getEmail()
		);
	}
}