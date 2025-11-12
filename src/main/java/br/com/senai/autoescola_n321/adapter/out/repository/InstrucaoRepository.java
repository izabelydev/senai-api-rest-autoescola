package br.com.senai.autoescola_n321.adapter.out.repository;

import br.com.senai.autoescola_n321.adapter.out.domain.entity.Instrucao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface InstrucaoRepository extends JpaRepository<Instrucao, Long> {

    Boolean existsByInstrutorIdAndDataAndCanceladaFalse(Long aLong, LocalDateTime data);

    Boolean existsByAlunoIdAndDataAndCanceladaFalse(Long aLong, LocalDateTime data);
}
