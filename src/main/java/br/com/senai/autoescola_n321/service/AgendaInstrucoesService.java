package br.com.senai.autoescola_n321.service;

import br.com.senai.autoescola_n321.adapter.in.dto.instrucao.DadosAgendamentoInstrucao;
import br.com.senai.autoescola_n321.adapter.in.dto.instrucao.DadosCancelamentoInstrucao;
import br.com.senai.autoescola_n321.adapter.in.dto.instrucao.DadosDetalhamentoInstrucao;
import br.com.senai.autoescola_n321.adapter.out.domain.entity.Instrucao;
import br.com.senai.autoescola_n321.adapter.out.domain.entity.Instrutor;
import br.com.senai.autoescola_n321.adapter.out.repository.AlunoRepository;
import br.com.senai.autoescola_n321.adapter.out.repository.InstrucaoRepository;
import br.com.senai.autoescola_n321.adapter.out.repository.InstrutorRepository;
import br.com.senai.autoescola_n321.infra.exception.AlunoNaoExisteException;
import br.com.senai.autoescola_n321.infra.exception.InstrutorIndisponivelException;
import br.com.senai.autoescola_n321.usecase.validacoes.ValidacoesUseCase;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    private List<ValidacoesUseCase> validacoesUseCase;

    @Transactional
    public DadosDetalhamentoInstrucao agendar(DadosAgendamentoInstrucao dados) {

        if(!alunoRepository.existsByIdAndAtivoTrue(dados.idAluno())) {
            throw new AlunoNaoExisteException("Aluno não existe ou é inativo.");
        }

        Instrutor instrutor = instrutorService.escolherInstrutor(dados).orElseThrow(
                () -> new InstrutorIndisponivelException("Nenhum instrutor com horário disponível para a data: "
                                                         + dados.data().toString())
        );

        validacoesUseCase.forEach(v -> v.validar(dados));

        Instrucao instrucao = new Instrucao (
                null,
                dados.data(),
                false,
                alunoService.getAluno(dados.idAluno()),
                instrutor
        );

        instrucaoRepository.save(instrucao);

        return new DadosDetalhamentoInstrucao(instrucao);
    }

    public void cancelar(DadosCancelamentoInstrucao dados) {

    }
}
