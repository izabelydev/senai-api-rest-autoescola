package br.com.senai.autoescola_n321.adapter.in.controller;

import br.com.senai.autoescola_n321.adapter.in.dto.instrucao.DadosAgendamentoInstrucao;
import br.com.senai.autoescola_n321.adapter.in.dto.instrucao.DadosCancelamentoInstrucao;
import br.com.senai.autoescola_n321.adapter.in.dto.instrucao.DadosDetalhamentoInstrucao;
import br.com.senai.autoescola_n321.adapter.in.dto.instrucao.DadosReagendamentoInstrucao;
import br.com.senai.autoescola_n321.service.AgendaInstrucoesService;
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
    public ResponseEntity<Void> cancelarInstrucao(
            @Valid @RequestBody DadosCancelamentoInstrucao dados
    ) {
        agendaInstrucoesService.cancelar(dados);
        return ResponseEntity.noContent().build();
    }

    @Transactional
    @PutMapping("/reagendar")
    public ResponseEntity<DadosDetalhamentoInstrucao> reagendarInstrucao(
            @Valid @RequestBody DadosReagendamentoInstrucao dados
    ) {
        agendaInstrucoesService.cancelar(dados.cancelamentoInstrucao());
        return ResponseEntity.ok(agendaInstrucoesService.agendar(dados.agendamentoInstrucao()));
    }

    @GetMapping("/ver-instrucoes")
    public ResponseEntity<Page<DadosDetalhamentoInstrucao>> listarInstrucoes(
            @PageableDefault(size=5, sort={"data"}) Pageable paginacao
    ) {
        return ResponseEntity.ok(agendaInstrucoesService.listar(paginacao));
    }
}
