package br.com.senai.autoescola_n321.adapter.in.controller;

import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.aluno.DadosAtualizacaoAluno;
import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.aluno.DadosCadastroAluno;
import br.com.senai.autoescola_n321.adapter.in.controller.dto.response.aluno.DadosListagemAluno;
import br.com.senai.autoescola_n321.application.core.domain.model.Aluno;
import br.com.senai.autoescola_n321.adapter.out.repository.persistence.AlunoJpaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private static AlunoJpaRepository alunoJpaRepository;

    @Transactional
    @PostMapping("/cadastrar")
    public ResponseEntity<DadosListagemAluno> cadastrarAluno(
            @RequestBody @Valid DadosCadastroAluno dados,
            UriComponentsBuilder uriBuilder
    ) {
        Aluno aluno = new Aluno(dados);
        alunoJpaRepository.save(new Aluno(dados));
        URI uri = uriBuilder.path("/alunos/aluno/{id}").buildAndExpand(aluno.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosListagemAluno(aluno));
    }

    @GetMapping("/listar-alunos")
    public ResponseEntity<Page<DadosListagemAluno>> listarAlunos(
            @PageableDefault(size=5, sort={"nome"}) Pageable paginacao
    ) {
        Page<DadosListagemAluno> page = alunoJpaRepository.findAllByAtivoTrue(paginacao)
                .map(DadosListagemAluno::new);
        return ResponseEntity.ok(page);
    }

    @Transactional
    @PutMapping("/atualizar-cadastro")
    public void atualizarAluno(
            @RequestBody @Valid DadosAtualizacaoAluno dados
    ) {
        Aluno aluno = getALuno(dados.id());
        Aluno aluno = alunoJpaRepository.getReferenceById(dados.id());
        aluno.atualizarInformacoes(dados);
    }

    @Transactional
    @DeleteMapping("/apagar-aluno/{id}")
    public void apagarAluno(@PathVariable Long id) {
        Aluno aluno = alunoJpaRepository.getReferenceById(id);
        aluno.apagar();
    }
}
