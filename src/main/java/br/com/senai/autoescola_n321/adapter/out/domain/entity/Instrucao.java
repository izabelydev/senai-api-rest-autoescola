package br.com.senai.autoescola_n321.adapter.out.domain.entity;

import br.com.senai.autoescola_n321.adapter.in.dto.instrucao.DadosAgendamentoInstrucao;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "instrucao")
@Table(name = "tb_itc")
@EqualsAndHashCode(of = "id")
public class Instrucao {

    @Id
    @Column(name = "itc_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "itc_dt")
    private LocalDateTime data;

    @Column(name = "itc_can")
    private Boolean cancelada = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "itc_alu_id")
    private Aluno aluno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "itc_ins_id")
    private Instrutor instrutor;
}
