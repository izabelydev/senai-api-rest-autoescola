package br.com.senai.autoescola_n321.application.ports.out;

public interface AlunoRepository {
    Boolean existsByIdAndAtivoTrue(Long aLong);
}
