package br.com.senai.autoescola_n321.adapter.out.repository.entity;

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

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_usu")
@Entity(name = "Usuario")
@EqualsAndHashCode(of = "id")
public class UsuarioEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usu_id")
    private Long id;

    @Column(name = "usu_lg")
    private String login;

    @Column(name = "usu_sn")
    private String senha;

    @Column(name = "usu_pfl", nullable = false)
    @Enumerated(EnumType.STRING)
    private Perfil perfil;

    @Column(name = "usu_atv")
    private Boolean ativo;

    public UsuarioEntity(DadosCadastramentoUsuario dados, BCryptPasswordEncoder passwordEncoder) {
        this.login = dados.login();
        this.senha = passwordEncoder.encode(dados.senha());
        this.perfil = dados.perfil() != null ? dados.perfil() : Perfil.USER;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + perfil));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void atualizarPerfil(@Valid DadosAtualizacaoPerfilUsuario dados) {
        if(!isNull(dados.perfil())) {
            this.perfil = dados.perfil();
        }
    }

    public void atualizarSenha(@Valid DadosAtualizacaoSenhaUsuario dados, BCryptPasswordEncoder passwordEncoder) {
        if(!isNull(dados.novaSenha())) {
            this.senha = passwordEncoder.encode(dados.novaSenha());
        }
    }

    public void apagar() {
        this.ativo = false;
    }
}
