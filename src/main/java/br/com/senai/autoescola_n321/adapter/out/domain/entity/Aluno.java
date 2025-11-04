package br.com.senai.autoescola_n321.adapter.out.domain.entity;

import static java.util.Objects.isNull;
import br.com.senai.autoescola_n321.adapter.in.dto.aluno.DadosAtualizacaoAluno;
import br.com.senai.autoescola_n321.adapter.in.dto.aluno.DadosCadastroAluno;
import br.com.senai.autoescola_n321.adapter.out.domain.valueobject.EnderecoAluno;
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

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_alu")
@Entity(name = "Aluno")
@EqualsAndHashCode(of = "id")
public class Aluno {

    @Id
    @Column(name = "alu_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "alu_atv")
    private Boolean ativo;

    @Column(name = "alu_nm")
    private String nome;

    @Column(name = "alu_eml")
    private String email;

    @Column(name = "alu_tel")
    private String telefone;

    @Column(name = "alu_cpf")
    private String cpf;

    @Embedded
    private EnderecoAluno endereco;

    public Aluno(DadosCadastroAluno dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.cpf = dados.cpf();
        this.endereco = new EnderecoAluno(dados.endereco());
    }

    public void atualizarInformacoes(DadosAtualizacaoAluno dados) {
        if (!isNull(dados.nome())) {
            this.nome = dados.nome();
        }

        if (!isNull(dados.telefone())) {
            this.telefone = dados.telefone();
        }

        if (!isNull(dados.endereco())) {
            endereco.atualizarInformacoes(dados.endereco());
        }
    }

    public void apagar() {
        this.ativo = false;
    }
}
