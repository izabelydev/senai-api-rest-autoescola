package br.com.senai.autoescola_n321.adapter.out.repository;

import br.com.senai.autoescola_n321.adapter.in.controller.dto.response.instrucao.DadosDetalhamentoInstrucao;
import br.com.senai.autoescola_n321.adapter.out.repository.entity.InstrucaoEntity;
import br.com.senai.autoescola_n321.adapter.out.repository.persistence.InstrucaoJpaRepository;
import br.com.senai.autoescola_n321.application.ports.out.InstrucaoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class InstrucaoRepositoryImpl implements InstrucaoRepository {

    private final InstrucaoJpaRepository repository;

    public InstrucaoRepositoryImpl(InstrucaoJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public InstrucaoEntity save(InstrucaoEntity instrucao) {
        return repository.save(instrucao);
    }

    @Override
    public Optional<InstrucaoEntity> findByIdAndCanceladaFalse(Long id) {
        return repository.findByIdAndCanceladaFalse(id);
    }

    @Override
    public Optional<Page<DadosDetalhamentoInstrucao>> findAllByCanceladaFalse(Pageable paginacao) {
        return null;
// TODO        return repository.findAllByCanceladaFalse(paginacao).map(DadosDetalhamentoInstrucao::new);
    }
}
