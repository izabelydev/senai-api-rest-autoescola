package br.com.senai.autoescola_n321.application.core.domain.model;

import br.com.senai.autoescola_n321.adapter.out.repository.entity.AlunoEntity;
import br.com.senai.autoescola_n321.adapter.out.repository.entity.InstrutorEntity;
import br.com.senai.autoescola_n321.application.core.domain.enums.MotivoCancelamento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Instrucao {

    private Long id;
    private LocalDateTime data;
    private LocalDateTime dataCancelamento;
    private Boolean cancelada = false;
    private MotivoCancelamento motivo;
    private AlunoEntity aluno;
    private InstrutorEntity instrutor;
}
