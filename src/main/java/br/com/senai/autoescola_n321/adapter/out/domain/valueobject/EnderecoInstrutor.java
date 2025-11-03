package br.com.senai.autoescola_n321.adapter.out.domain.valueobject;

import br.com.senai.autoescola_n321.adapter.in.dto.endereco.DadosEndereco;
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

    public EnderecoInstrutor(DadosEndereco dados) {
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
