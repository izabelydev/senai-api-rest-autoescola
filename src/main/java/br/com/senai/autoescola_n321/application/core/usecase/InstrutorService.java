package br.com.senai.autoescola_n321.application.core.usecase;

import static java.util.Objects.isNull;

import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.instrucao.DadosAgendamentoInstrucao;
import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.instrutor.DadosCadastroInstrutor;
import br.com.senai.autoescola_n321.adapter.in.controller.dto.response.instrutor.DadosDetalhamentoInstrutor;
import br.com.senai.autoescola_n321.adapter.in.controller.mapper.InstrutorMapper;
import br.com.senai.autoescola_n321.adapter.out.repository.persistence.InstrutorRepository;
import br.com.senai.autoescola_n321.application.core.domain.model.Instrutor;
import br.com.senai.autoescola_n321.exception.types.business.EspecialidadeNaoInformadaException;
import br.com.senai.autoescola_n321.exception.types.business.InstrutorNaoExisteException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InstrutorService {

    private final InstrutorRepository instrutorRepository;
    private final InstrutorMapper instrutorMapper;

    public InstrutorService(InstrutorRepository instrutorRepository, InstrutorMapper instrutorMapper) {
        this.instrutorRepository = instrutorRepository;
        this.instrutorMapper = instrutorMapper;
    }

    @Transactional
    public DadosDetalhamentoInstrutor cadastrar(DadosCadastroInstrutor dados) {
        Instrutor instrutor = new Instrutor(dados);
        instrutorRepository.save(instrutor);
        return instrutorMapper.toDto(instrutor);
    }

    public Instrutor getInstrutor(Long id) {
        return instrutorRepository.findByIdAndAtivoTrue(id)
                .orElseThrow(() -> new InstrutorNaoExisteException("Instrutor não encontrado ou inativo"));
    }

    public Optional<Instrutor> escolherInstrutor(DadosAgendamentoInstrucao dados) {
        if(!isNull(dados.idInstrutor())) {
            return Optional.ofNullable(getInstrutor(dados.idInstrutor()));
        }

        if(isNull(dados.especialidade())) {
            throw new EspecialidadeNaoInformadaException("Especialidade é obrigatória se o instrutor não é informado");
        }

        return Optional.ofNullable(instrutorRepository.escolherInstrutorDisponivel(dados.especialidade(), dados.data()));
    }
}
