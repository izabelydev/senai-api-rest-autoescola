package br.com.senai.autoescola_n321.application.core.domain.model;

import br.com.senai.autoescola_n321.adapter.out.repository.entity.InstrutorEntity;
import br.com.senai.autoescola_n321.application.core.domain.enums.MotivoCancelamento;

import java.time.LocalDateTime;

public class Instrucao {

    private Long id;
    private LocalDateTime data;
    private LocalDateTime dataCancelamento;
    private Boolean cancelada = false;
    private MotivoCancelamento motivo;
    private Aluno aluno;
    private InstrutorEntity instrutor;
}
