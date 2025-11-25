package br.com.senai.autoescola_n321.adapter.in.controller;

import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.aluno.DadosAtualizacaoAluno;
import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.aluno.DadosCadastroAluno;
import br.com.senai.autoescola_n321.adapter.in.controller.dto.response.aluno.DadosDetalhamentoAluno;
import br.com.senai.autoescola_n321.adapter.in.controller.dto.response.aluno.DadosListagemAluno;
import br.com.senai.autoescola_n321.application.core.usecase.AlunoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
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

   private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<DadosDetalhamentoAluno> cadastrarAluno(
            @RequestBody @Valid DadosCadastroAluno dados,
            UriComponentsBuilder uriBuilder
    ) {
        DadosDetalhamentoAluno dto = alunoService.cadastrar(dados);
        URI uri = uriBuilder.path("/alunos/aluno/{id}").buildAndExpand(dto.id()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping("/listar-alunos")
    public ResponseEntity<Page<DadosListagemAluno>> listarAlunos(
            @PageableDefault(size=5, sort={"nome"}) Pageable paginacao
    ) {
        return ResponseEntity.ok(alunoService.listar(paginacao));
    }

    @PutMapping("/atualizar-cadastro")
    public ResponseEntity<DadosDetalhamentoAluno> atualizarAluno(
            @RequestBody @Valid DadosAtualizacaoAluno dados
    ) {
        return ResponseEntity.ok(alunoService.atualizar(dados));
    }

    @DeleteMapping("/apagar-aluno/{id}")
    public ResponseEntity<DadosDetalhamentoAluno> apagarAluno(@PathVariable Long id) {
        return ResponseEntity.ok(alunoService.apagar(id));
    }

    @GetMapping("aluno/{id}")
    public ResponseEntity<DadosDetalhamentoAluno> detalharAluno(@PathVariable Long id) {
        return ResponseEntity.ok(alunoService.detalhar(id));
    }
}
