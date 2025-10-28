package br.com.senai.autoescola_n321.adapter.out.domain.entity;

import br.com.senai.autoescola_n321.adapter.in.dto.instrutor.DadosCadastroInstrutor;
import br.com.senai.autoescola_n321.adapter.in.dto.instrutor.enums.Especialidade;
import br.com.senai.autoescola_n321.adapter.out.domain.valueobject.Endereco;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
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

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_ins")
@Entity(name = "Instrutor")
@EqualsAndHashCode(of = "id")
public class Instrutor {

    @Id
    @Column(name = "ins_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ins_nm")
    private String nome;

    @Column(name = "ins_eml")
    private String email;

    @Column(name = "ins_cnh")
    private String cnh;

    @Column(name = "ins_esp")
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    public Instrutor(DadosCadastroInstrutor dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.cnh = dados.cnh();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
    }
}
