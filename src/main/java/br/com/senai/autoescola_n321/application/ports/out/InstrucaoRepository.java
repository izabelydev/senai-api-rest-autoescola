package br.com.senai.autoescola_n321.application.ports.out;

import br.com.senai.autoescola_n321.adapter.in.controller.dto.response.instrucao.DadosDetalhamentoInstrucao;
import br.com.senai.autoescola_n321.adapter.out.repository.entity.InstrucaoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface InstrucaoRepository {
    InstrucaoEntity save(InstrucaoEntity instrucao);

    Optional<InstrucaoEntity> findByIdAndCanceladaFalse(Long id);

    Optional<Page<DadosDetalhamentoInstrucao>> findAllByCanceladaFalse(Pageable paginacao);
}
