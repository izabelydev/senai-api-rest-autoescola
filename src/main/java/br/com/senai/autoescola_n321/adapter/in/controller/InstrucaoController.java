package br.com.senai.autoescola_n321.adapter.in.controller;

import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.instrucao.DadosAgendamentoInstrucao;
import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.instrucao.DadosCancelamentoInstrucao;
import br.com.senai.autoescola_n321.adapter.in.controller.dto.response.instrucao.DadosDetalhamentoCancelamento;
import br.com.senai.autoescola_n321.adapter.in.controller.dto.response.instrucao.DadosDetalhamentoInstrucao;
import br.com.senai.autoescola_n321.adapter.in.controller.dto.response.instrucao.DadosDetalhamentoReagendamento;
import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.instrucao.DadosReagendamentoInstrucao;
import br.com.senai.autoescola_n321.application.core.usecase.AgendaInstrucoesService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/instrucao")
public class InstrucaoController {

    @Autowired
    private AgendaInstrucoesService agendaInstrucoesService;

    @Transactional
    @PostMapping("/agendar")
    public ResponseEntity<DadosDetalhamentoInstrucao> agendarInstrucao(
            @Valid @RequestBody DadosAgendamentoInstrucao dados
    ) {
        return ResponseEntity.ok(agendaInstrucoesService.agendar(dados));
    }

    @Transactional
    @DeleteMapping("/cancelar")
    public ResponseEntity<DadosDetalhamentoCancelamento> cancelarInstrucao(
            @Valid @RequestBody DadosCancelamentoInstrucao dados
    ) {
        return ResponseEntity.ok().body(agendaInstrucoesService.cancelar(dados));
    }

    @Transactional
    @PutMapping("/reagendar")
    public ResponseEntity<DadosDetalhamentoReagendamento> reagendarInstrucao(
            @Valid @RequestBody DadosReagendamentoInstrucao dados
    ) {
        return ResponseEntity.ok().body(agendaInstrucoesService.reagendar(dados));
    }

    @GetMapping("/ver-instrucoes")
    public ResponseEntity<Page<DadosDetalhamentoInstrucao>> listarInstrucoes(
            @PageableDefault(size=5, sort={"data"}) Pageable paginacao
    ) {
        return ResponseEntity.ok(agendaInstrucoesService.listar(paginacao));
    }
}
