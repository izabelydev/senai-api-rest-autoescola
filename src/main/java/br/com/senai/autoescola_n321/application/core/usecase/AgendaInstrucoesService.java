package br.com.senai.autoescola_n321.application.core.usecase;

import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.instrucao.DadosAgendamentoInstrucao;
import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.instrucao.DadosCancelamentoInstrucao;
import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.instrucao.DadosReagendamentoInstrucao;
import br.com.senai.autoescola_n321.adapter.in.controller.dto.response.instrucao.DadosDetalhamentoCancelamento;
import br.com.senai.autoescola_n321.adapter.in.controller.dto.response.instrucao.DadosDetalhamentoInstrucao;
import br.com.senai.autoescola_n321.adapter.in.controller.dto.response.instrucao.DadosDetalhamentoReagendamento;
import br.com.senai.autoescola_n321.adapter.out.repository.entity.InstrucaoEntity;
import br.com.senai.autoescola_n321.adapter.out.repository.entity.InstrutorEntity;
import br.com.senai.autoescola_n321.application.core.validations.instrucao.agendamento.ValidacoesAgendamento;
import br.com.senai.autoescola_n321.application.core.validations.instrucao.cancelamento.ValidacoesCancelamento;
import br.com.senai.autoescola_n321.application.ports.out.AlunoRepository;
import br.com.senai.autoescola_n321.application.ports.out.InstrucaoRepository;
import br.com.senai.autoescola_n321.exception.types.business.AlunoNaoExisteException;
import br.com.senai.autoescola_n321.exception.types.business.InstrucaoNaoExisteException;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaInstrucoesService {

    private final InstrutorService instrutorService;
    private final AlunoService alunoService;
    private final AlunoRepository alunoRepository;
    private final InstrucaoRepository instrucaoRepository;
    private final List<ValidacoesAgendamento> validacoesAgendamentos;
    private final List<ValidacoesCancelamento> validacoesCancelamentos;

    public AgendaInstrucoesService(
            InstrutorService instrutorService,
            AlunoService alunoService,
            AlunoRepository alunoRepository,
            InstrucaoRepository instrucaoRepository,
            List<ValidacoesAgendamento> validacoesAgendamentos,
            List<ValidacoesCancelamento> validacoesCancelamentos
    ) {
        this.instrutorService = instrutorService;
        this.alunoService = alunoService;
        this.alunoRepository = alunoRepository;
        this.instrucaoRepository = instrucaoRepository;
        this.validacoesAgendamentos = validacoesAgendamentos;
        this.validacoesCancelamentos = validacoesCancelamentos;
    }

    @Transactional
    public DadosDetalhamentoInstrucao agendar(DadosAgendamentoInstrucao dados) {

        if(!alunoRepository.existsByIdAndAtivoTrue(dados.idAluno())) {
            throw new AlunoNaoExisteException("Aluno não existe ou é inativo.");
        }

        InstrutorEntity instrutor = instrutorService.escolherInstrutor(dados);

        validacoesAgendamentos.forEach(v -> v.validar(dados));

        InstrucaoEntity instrucao = new InstrucaoEntity (
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
        InstrucaoEntity instrucao = instrucaoRepository.findByIdAndCanceladaFalse(dados.id())
                .orElseThrow(() -> new InstrucaoNaoExisteException("Nenhuma instrução encontrada."));

        validacoesCancelamentos.forEach(v -> v.validar(instrucao));

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
        return null;
// TODO        return instrucaoRepository.findAllByCanceladaFalse(paginacao).map(DadosDetalhamentoInstrucao::new);
    }
}
