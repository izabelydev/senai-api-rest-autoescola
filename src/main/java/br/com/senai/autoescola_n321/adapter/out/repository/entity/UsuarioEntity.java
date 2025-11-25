package br.com.senai.autoescola_n321.adapter.out.repository.entity;

import br.com.senai.autoescola_n321.application.core.domain.enums.Perfil;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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

    @Setter
    @Column(name = "usu_sn")
    private String senha;

    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "usu_pfl", nullable = false)
    private Perfil perfil;

    @Setter
    @Column(name = "usu_atv")
    private Boolean ativo;

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
}
