package br.com.senai.autoescola_n321.application.core.domain.model;

import static java.util.Objects.isNull;

import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.usuario.DadosAtualizacaoPerfilUsuario;
import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.usuario.DadosAtualizacaoSenhaUsuario;
import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.usuario.DadosCadastramentoUsuario;
import br.com.senai.autoescola_n321.application.core.domain.enums.Perfil;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;
import java.util.List;

public class Usuario implements UserDetails {

    private Long id;
    private String login;
    private String senha;
    private Perfil perfil;
    private Boolean ativo;
}
