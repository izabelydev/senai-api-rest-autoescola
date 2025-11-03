package br.com.senai.autoescola_n321.adapter.in.dto.aluno;


import br.com.senai.autoescola_n321.adapter.out.domain.entity.Aluno;

public record DadosListagemAluno(
		Long id,
		String nome,
		String cpf,
		String email
) {
	public DadosListagemAluno(Aluno aluno) {
		this(
				aluno.getId(),
				aluno.getNome(),
				aluno.getCpf(),
				aluno.getEmail()
		);
	}
}