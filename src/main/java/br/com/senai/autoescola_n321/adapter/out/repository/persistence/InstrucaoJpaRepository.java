package br.com.senai.autoescola_n321.adapter.out.repository.persistence;

import br.com.senai.autoescola_n321.adapter.in.controller.dto.response.instrucao.DadosDetalhamentoInstrucao;
import br.com.senai.autoescola_n321.adapter.out.repository.entity.InstrucaoEntity;
import br.com.senai.autoescola_n321.application.core.domain.model.Instrucao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface InstrucaoJpaRepository extends JpaRepository<InstrucaoEntity, Long> {

    Boolean existsByInstrutorIdAndDataAndCanceladaFalse(Long id, LocalDateTime data);

    Boolean existsByAlunoIdAndDataBetweenAndCanceladaFalse(Long id, LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim);

    Optional<InstrucaoEntity> findByIdAndCanceladaFalse(Long id);

    Optional<Page<DadosDetalhamentoInstrucao>> findAllByCanceladaFalse(Pageable paginacao);
}
