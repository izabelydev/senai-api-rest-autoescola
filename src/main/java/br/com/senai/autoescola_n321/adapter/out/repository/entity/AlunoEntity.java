package br.com.senai.autoescola_n321.adapter.out.repository.entity;

import br.com.senai.autoescola_n321.application.core.domain.vo.EnderecoAluno;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_alu")
@Entity(name = "Aluno")
@EqualsAndHashCode(of = "id")
public class AlunoEntity {

    @Id
    @Column(name = "alu_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(name = "alu_atv")
    private Boolean ativo;

    @Setter
    @Column(name = "alu_nm")
    private String nome;

    @Column(name = "alu_eml")
    private String email;

    @Setter
    @Column(name = "alu_tel")
    private String telefone;

    @Column(name = "alu_cpf")
    private String cpf;

    @Embedded
    private EnderecoAluno endereco;
}
