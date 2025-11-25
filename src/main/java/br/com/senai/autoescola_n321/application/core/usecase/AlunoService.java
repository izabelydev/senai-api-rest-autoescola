package br.com.senai.autoescola_n321.application.core.usecase;

import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.aluno.DadosAtualizacaoAluno;
import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.aluno.DadosCadastroAluno;
import br.com.senai.autoescola_n321.adapter.in.controller.dto.response.aluno.DadosDetalhamentoAluno;
import br.com.senai.autoescola_n321.adapter.in.controller.dto.response.aluno.DadosListagemAluno;
import br.com.senai.autoescola_n321.adapter.in.controller.mapper.AlunoMapper;
import br.com.senai.autoescola_n321.adapter.out.repository.entity.AlunoEntity;
import br.com.senai.autoescola_n321.application.ports.out.AlunoRepository;
import br.com.senai.autoescola_n321.exception.types.business.AlunoNaoExisteException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final AlunoMapper alunoMapper;

    public AlunoService(AlunoRepository alunoRepository, AlunoMapper alunoMapper) {
        this.alunoRepository = alunoRepository;
        this.alunoMapper = alunoMapper;
    }

    @Transactional
    public DadosDetalhamentoAluno cadastrar(DadosCadastroAluno dados) {
        AlunoEntity aluno = alunoMapper.toEntity(dados);
        alunoRepository.save(aluno);
        return alunoMapper.toDetailsDto(aluno);
    }

    public Page<DadosListagemAluno> listar(Pageable paginacao) {
        return alunoRepository.findAllByAtivoTrue(paginacao).map(alunoMapper::toListDto);
    }

    @Transactional
    public DadosDetalhamentoAluno atualizar(DadosAtualizacaoAluno dados) {
        AlunoEntity aluno = getAluno(dados.id());
        alunoMapper.atualizarDtoToEntity(dados, aluno);
        alunoRepository.save(aluno);
        return alunoMapper.toDetailsDto(aluno);
    }

    @Transactional
    public DadosDetalhamentoAluno apagar(Long id) {
        AlunoEntity aluno = getAluno(id);
        aluno.setAtivo(false);
        alunoRepository.save(aluno);
        return alunoMapper.toDetailsDto(aluno);
    }

    public DadosDetalhamentoAluno detalhar(Long id) {
        return alunoMapper.toDetailsDto(alunoRepository.findById(id)
                .orElseThrow(() -> new AlunoNaoExisteException("Aluno não existe.")));
    }

    public AlunoEntity getAluno(Long id) {
        return alunoRepository.findByIdAndAtivoTrue(id)
                .orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado ou inativo"));
    }
}
