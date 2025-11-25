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
public class EnderecoInstrutor {

    @Column(name = "ins_end_lgd")
    private String logradouro;

    @Column(name = "ins_end_bai")
    private String bairro;

    @Column(name = "ins_end_uf")
    private String uf;

    @Column(name = "ins_end_cid")
    private String cidade;

    @Column(name = "ins_end_cep")
    private String cep;

    @Column(name = "ins_end_cmp")
    private String complemento;

    @Column(name = "ins_end_num")
    private String numero;
}
