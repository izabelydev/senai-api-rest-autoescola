package br.com.senai.autoescola_n321.application.core.domain.model;

import br.com.senai.autoescola_n321.application.core.domain.vo.EnderecoAluno;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Aluno {

    private Long id;
    private Boolean ativo;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private EnderecoAluno endereco;
}
