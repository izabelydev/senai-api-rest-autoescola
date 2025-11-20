package br.com.senai.autoescola_n321.adapter.out.repository.entity;

import br.com.senai.autoescola_n321.application.core.domain.enums.Especialidade;
import br.com.senai.autoescola_n321.application.core.domain.vo.EnderecoInstrutor;
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
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_ins")
@Entity(name = "Instrutor")
@EqualsAndHashCode(of = "id")
public class InstrutorEntity {

    @Id
    @Column(name = "ins_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(name = "ins_atv")
    private Boolean ativo;

    @Setter
    @Column(name = "ins_nm")
    private String nome;

    @Column(name = "ins_eml")
    private String email;

    @Setter
    @Column(name = "ins_tel")
    private String telefone;

    @Column(name = "ins_cnh")
    private String cnh;

    @Setter
    @Column(name = "ins_esp")
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private EnderecoInstrutor endereco;
}
