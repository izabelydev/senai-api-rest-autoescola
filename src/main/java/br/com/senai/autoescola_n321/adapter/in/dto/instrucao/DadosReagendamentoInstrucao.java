package br.com.senai.autoescola_n321.adapter.in.dto.instrucao;

public record DadosReagendamentoInstrucao(
   DadosCancelamentoInstrucao cancelamentoInstrucao,
   DadosAgendamentoInstrucao agendamentoInstrucao
) {}
