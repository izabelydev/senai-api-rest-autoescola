package br.com.senai.autoescola_n321.adapter.in.controller;

import br.com.senai.autoescola_n321.adapter.in.dto.instrucao.DadosAgendamentoInstrucao;
import br.com.senai.autoescola_n321.adapter.in.dto.instrucao.DadosCancelamentoInstrucao;
import br.com.senai.autoescola_n321.adapter.in.dto.instrucao.DadosDetalhamentoInstrucao;
import br.com.senai.autoescola_n321.service.AgendaInstrucoesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/instrucao")
public class InstrucaoController {

    @Autowired
    private AgendaInstrucoesService agendaInstrucoesService;

    @PostMapping("/agendar")
    public ResponseEntity<DadosDetalhamentoInstrucao> agendarInstrucao(
            @Valid @RequestBody DadosAgendamentoInstrucao dados
    ) {
        return ResponseEntity.ok(agendaInstrucoesService.agendar(dados));
    }

    @DeleteMapping("/cancelar")
    public ResponseEntity<Void> cancelarInstrucao(
            @Valid @RequestBody DadosCancelamentoInstrucao dados
    ) {
        agendaInstrucoesService.cancelar(dados);
        return ResponseEntity.noContent().build();
    }
}
