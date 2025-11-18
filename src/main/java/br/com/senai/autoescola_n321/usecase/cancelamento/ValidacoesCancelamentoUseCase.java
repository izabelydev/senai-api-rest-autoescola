package br.com.senai.autoescola_n321.usecase.cancelamento;

import br.com.senai.autoescola_n321.adapter.out.domain.entity.Instrucao;

public interface ValidacoesCancelamentoUseCase {
    void validar(Instrucao dados);
}
