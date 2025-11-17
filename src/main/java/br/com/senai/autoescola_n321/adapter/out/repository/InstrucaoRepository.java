package br.com.senai.autoescola_n321.adapter.out.repository;

import br.com.senai.autoescola_n321.adapter.in.dto.instrucao.DadosDetalhamentoInstrucao;
import br.com.senai.autoescola_n321.adapter.out.domain.entity.Instrucao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface InstrucaoRepository extends JpaRepository<Instrucao, Long> {

    Boolean existsByInstrutorIdAndDataAndCanceladaFalse(Long id, LocalDateTime data);

    Boolean existsByAlunoIdAndDataBetweenAndCanceladaFalse(Long id, LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim);

    Optional<Instrucao> findByIdAndCanceladaFalse(Long id);

    Page<Instrucao> findAllByCanceladaFalse(Pageable paginacao);
}
