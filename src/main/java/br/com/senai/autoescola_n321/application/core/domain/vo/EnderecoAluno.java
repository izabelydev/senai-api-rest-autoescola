package br.com.senai.autoescola_n321.application.core.domain.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class EnderecoAluno {

    @Column(name = "alu_end_lgd")
    private String logradouro;

    @Column(name = "alu_end_bai")
    private String bairro;

    @Column(name = "alu_end_uf")
    private String uf;

    @Column(name = "alu_end_cid")
    private String cidade;

    @Column(name = "alu_end_cep")
    private String cep;

    @Column(name = "alu_end_cmp")
    private String complemento;

    @Column(name = "alu_end_num")
    private String numero;
}
