package br.com.senai.autoescola_n321.service;

import br.com.senai.autoescola_n321.adapter.in.dto.instrucao.DadosAgendamentoInstrucao;
import br.com.senai.autoescola_n321.adapter.in.dto.instrucao.DadosCancelamentoInstrucao;
import br.com.senai.autoescola_n321.adapter.in.dto.instrucao.DadosDetalhamentoCancelamento;
import br.com.senai.autoescola_n321.adapter.in.dto.instrucao.DadosDetalhamentoInstrucao;
import br.com.senai.autoescola_n321.adapter.in.dto.instrucao.DadosDetalhamentoReagendamento;
import br.com.senai.autoescola_n321.adapter.in.dto.instrucao.DadosReagendamentoInstrucao;
import br.com.senai.autoescola_n321.adapter.out.domain.entity.Instrucao;
import br.com.senai.autoescola_n321.adapter.out.domain.entity.Instrutor;
import br.com.senai.autoescola_n321.adapter.out.repository.AlunoRepository;
import br.com.senai.autoescola_n321.adapter.out.repository.InstrucaoRepository;
import br.com.senai.autoescola_n321.adapter.out.repository.InstrutorRepository;
import br.com.senai.autoescola_n321.infra.exception.AlunoNaoExisteException;
import br.com.senai.autoescola_n321.infra.exception.InstrucaoNaoExisteException;
import br.com.senai.autoescola_n321.infra.exception.InstrutorIndisponivelException;
import br.com.senai.autoescola_n321.infra.exception.ValidacaoException;
import br.com.senai.autoescola_n321.usecase.agendamento.ValidacoesAgendamentoUseCase;
import br.com.senai.autoescola_n321.usecase.cancelamento.ValidacoesCancelamentoUseCase;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaInstrucoesService {

    @Autowired
    private InstrucaoRepository instrucaoRepository;

    @Autowired
    private InstrutorService instrutorService;

    @Autowired
    private InstrutorRepository instrutorRepository;

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private List<ValidacoesAgendamentoUseCase> validacoesAgendamentoUseCases;

    @Autowired
    private List<ValidacoesCancelamentoUseCase> validacoesCancelamentoUseCases;

    @Transactional
    public DadosDetalhamentoInstrucao agendar(DadosAgendamentoInstrucao dados) {

        if(!alunoRepository.existsByIdAndAtivoTrue(dados.idAluno())) {
            throw new AlunoNaoExisteException("Aluno não existe ou é inativo.");
        }

        Instrutor instrutor = instrutorService.escolherInstrutor(dados).orElseThrow(
                () -> new InstrutorIndisponivelException("Nenhum instrutor com horário disponível para a data: "
                                                         + dados.data().toString())
        );

        validacoesAgendamentoUseCases.forEach(v -> v.validar(dados));

        Instrucao instrucao = new Instrucao (
                null,
                dados.data(),
                null,
                false,
                null,
                alunoService.getAluno(dados.idAluno()),
                instrutor
        );

        instrucaoRepository.save(instrucao);

        return new DadosDetalhamentoInstrucao(instrucao);
    }

    public DadosDetalhamentoCancelamento cancelar(DadosCancelamentoInstrucao dados) {
        Instrucao instrucao = instrucaoRepository.findByIdAndCanceladaFalse(dados.id())
                .orElseThrow(() -> new InstrucaoNaoExisteException("Nenhuma instrução encontrada."));

        validacoesCancelamentoUseCases.forEach(v -> v.validar(instrucao));

        instrucao.cancelar(dados);
        instrucaoRepository.save(instrucao);

        return new DadosDetalhamentoCancelamento(instrucao);
    }

    public DadosDetalhamentoReagendamento reagendar(DadosReagendamentoInstrucao dados) {
        DadosDetalhamentoCancelamento cancelamento = cancelar(dados.cancelamentoInstrucao());
        DadosDetalhamentoInstrucao agendamento = agendar(dados.agendamentoInstrucao());
        return new DadosDetalhamentoReagendamento(cancelamento, agendamento);
    }

    public Page<DadosDetalhamentoInstrucao> listar(Pageable paginacao) {
        return instrucaoRepository.findAllByCanceladaFalse(paginacao).map(DadosDetalhamentoInstrucao::new);
    }
}
