package br.com.senai.autoescola_n321.application.core.domain.model;

import br.com.senai.autoescola_n321.application.core.domain.enums.Especialidade;
import br.com.senai.autoescola_n321.application.core.domain.vo.EnderecoInstrutor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Instrutor {

    private Long id;

    @Setter
    private Boolean ativo;

    @Setter
    private String nome;
    private String email;

    @Setter
    private String telefone;
    private String cnh;

    @Setter
    private Especialidade especialidade;
    private EnderecoInstrutor endereco;
}
