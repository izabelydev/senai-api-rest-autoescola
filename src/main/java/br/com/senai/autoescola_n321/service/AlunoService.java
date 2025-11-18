package br.com.senai.autoescola_n321.service;

import br.com.senai.autoescola_n321.adapter.out.domain.entity.Aluno;
import br.com.senai.autoescola_n321.adapter.out.repository.AlunoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    @Autowired
    private static AlunoRepository alunoRepository;

    public Aluno getAluno(@NotNull Long id) {
        return alunoRepository.findAllByIdAndAtivoTrue(id)
                .orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado ou inativo"));
    }
}
