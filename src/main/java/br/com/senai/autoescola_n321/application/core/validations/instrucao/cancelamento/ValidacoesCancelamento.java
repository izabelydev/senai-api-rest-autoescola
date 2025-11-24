package br.com.senai.autoescola_n321.application.core.validations.instrucao.cancelamento;

import br.com.senai.autoescola_n321.adapter.out.repository.entity.InstrucaoEntity;

public interface ValidacoesCancelamento {
    void validar(InstrucaoEntity dados);
}
