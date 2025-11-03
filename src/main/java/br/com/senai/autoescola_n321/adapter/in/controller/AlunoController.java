package br.com.senai.autoescola_n321.adapter.in.controller;

import br.com.senai.autoescola_n321.adapter.in.dto.aluno.DadosAtualizacaoAluno;
import br.com.senai.autoescola_n321.adapter.in.dto.aluno.DadosCadastroAluno;
import br.com.senai.autoescola_n321.adapter.in.dto.aluno.DadosListagemAluno;
import br.com.senai.autoescola_n321.adapter.out.domain.entity.Aluno;
import br.com.senai.autoescola_n321.adapter.out.domain.repository.AlunoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @Transactional
    @PostMapping("/cadastrar")
    public void cadastrarAluno(@RequestBody @Valid DadosCadastroAluno dados) {
        alunoRepository.save(new Aluno(dados));
    }

    @GetMapping("/listar-alunos")
    public Page<DadosListagemAluno> listarAlunos(@PageableDefault(size=5, sort={"nome"}) Pageable paginacao) {
        return alunoRepository.findAllByAtivoTrue(paginacao).map(DadosListagemAluno::new);
    }

    @Transactional
    @PutMapping("/atualizar-cadastro")
    public void atualizarAluno(@RequestBody @Valid DadosAtualizacaoAluno dados) {
        Aluno aluno = alunoRepository.getReferenceById(dados.id());
        aluno.atualizarInformacoes(dados);
    }

    @Transactional
    @DeleteMapping("/apagar-aluno/{id}")
    public void apagarAluno(@PathVariable Long id) {
        Aluno aluno = alunoRepository.getReferenceById(id);
        aluno.apagar();
    }
}
