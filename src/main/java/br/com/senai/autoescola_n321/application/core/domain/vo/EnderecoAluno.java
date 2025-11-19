package br.com.senai.autoescola_n321.application.core.domain.vo;

import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.endereco.DadosEndereco;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
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

    public EnderecoAluno(DadosEndereco dados) {
        this.logradouro = dados.logradouro();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
        this.bairro = dados.bairro();
        this.cidade = dados.cidade();
        this.uf = dados.uf();
        this.cep = dados.cep();
    }

    public void atualizarInformacoes(@Valid DadosEndereco dados) {
        this.logradouro = dados.logradouro();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
        this.bairro = dados.bairro();
        this.cidade = dados.cidade();
        this.uf = dados.uf();
        this.cep = dados.cep();
    }
}
