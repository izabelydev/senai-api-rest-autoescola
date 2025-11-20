package br.com.senai.autoescola_n321.application.core.usecase;

import static java.util.Objects.isNull;

import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.instrucao.DadosAgendamentoInstrucao;
import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.instrutor.DadosAtualizacaoInstrutor;
import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.instrutor.DadosCadastroInstrutor;
import br.com.senai.autoescola_n321.adapter.in.controller.dto.response.instrutor.DadosDetalhamentoInstrutor;
import br.com.senai.autoescola_n321.adapter.in.controller.dto.response.instrutor.DadosListagemInstrutor;
import br.com.senai.autoescola_n321.adapter.in.controller.mapper.InstrutorMapper;
import br.com.senai.autoescola_n321.application.core.domain.model.Instrutor;
import br.com.senai.autoescola_n321.application.ports.out.InstrutorRepository;
import br.com.senai.autoescola_n321.exception.types.business.EspecialidadeNaoInformadaException;
import br.com.senai.autoescola_n321.exception.types.business.InstrutorIndisponivelException;
import br.com.senai.autoescola_n321.exception.types.business.InstrutorNaoExisteException;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
        Instrutor instrutor = instrutorMapper.toEntity(dados);
        instrutorRepository.save(instrutor);
        return instrutorMapper.toDetailsDto(instrutor);
    }

    public Page<DadosListagemInstrutor> listar(Pageable paginacao) {
        return instrutorRepository.findAllByAtivoTrue(paginacao).map(instrutorMapper::toListDto);
    }

    @Transactional
    public DadosDetalhamentoInstrutor atualizar(DadosAtualizacaoInstrutor dados) {
        Instrutor instrutor = getInstrutor(dados.id());
        instrutorMapper.atualizarDtoToEntity(dados, instrutor);
        instrutorRepository.save(instrutor);
        return instrutorMapper.toDetailsDto(instrutor);
    }

    @Transactional
    public DadosDetalhamentoInstrutor apagar(Long id) {
        Instrutor instrutor = getInstrutor(id);
        instrutor.setAtivo(false);
        instrutorRepository.save(instrutor);
        return instrutorMapper.toDetailsDto(instrutor);
    }

    public DadosDetalhamentoInstrutor detalhar(Long id) {
        return instrutorMapper.toDetailsDto(instrutorRepository.findById(id)
                .orElseThrow(() -> new InstrutorNaoExisteException("Instrutor não existe.")));
    }

    public Instrutor escolherInstrutor(DadosAgendamentoInstrucao dados) {
        if(!isNull(dados.idInstrutor())) {
            return getInstrutor(dados.idInstrutor());
        }

        if(isNull(dados.especialidade())) {
            throw new EspecialidadeNaoInformadaException("Especialidade é obrigatória se o instrutor não é informado");
        }

        return instrutorRepository.escolherInstrutorDisponivel(dados.especialidade(), dados.data())
                .orElseThrow(() -> new InstrutorIndisponivelException(
                        "Nenhum instrutor com horário disponível para a data: " + dados.data().toString()));
    }

    public Instrutor getInstrutor(Long id) {
        return instrutorRepository.findByIdAndAtivoTrue(id)
                .orElseThrow(() -> new InstrutorNaoExisteException("Instrutor não encontrado ou inativo"));
    }
}
