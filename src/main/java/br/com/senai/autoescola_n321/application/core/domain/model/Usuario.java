package br.com.senai.autoescola_n321.application.core.domain.model;

import br.com.senai.autoescola_n321.application.core.domain.enums.Perfil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    private Long id;
    private String login;
    private String senha;
    private Perfil perfil;
    private Boolean ativo;
}
