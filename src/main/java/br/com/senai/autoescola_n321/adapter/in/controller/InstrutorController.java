package br.com.senai.autoescola_n321.adapter.in.controller;

import static java.util.Objects.isNull;
import br.com.senai.autoescola_n321.adapter.in.dto.instrutor.DadosAtualizacaoInstrutor;
import br.com.senai.autoescola_n321.adapter.in.dto.instrutor.DadosCadastroInstrutor;
import br.com.senai.autoescola_n321.adapter.in.dto.instrutor.DadosDetalhamentoInstrutor;
import br.com.senai.autoescola_n321.adapter.in.dto.instrutor.DadosListagemInstrutor;
import br.com.senai.autoescola_n321.adapter.out.domain.entity.Instrutor;
import br.com.senai.autoescola_n321.adapter.out.domain.repository.InstrutorRepository;
import jakarta.persistence.EntityNotFoundException;
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
@RequestMapping("/instrutores")
public class InstrutorController {

    @Autowired
    private InstrutorRepository instrutorRepository;

    @Transactional
    @PostMapping("/cadastrar")
    public ResponseEntity<DadosDetalhamentoInstrutor> cadastrarInstrutor(
            @RequestBody @Valid DadosCadastroInstrutor dados,
            UriComponentsBuilder uriBuilder
    ) {
        Instrutor instrutor = new Instrutor(dados);
        instrutorRepository.save(instrutor);
        URI uri = uriBuilder.path("/instrutores/instrutor/{id}").buildAndExpand(instrutor.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoInstrutor(instrutor));
    }

    @GetMapping("/listar-instrutores")
    public ResponseEntity<Page<DadosListagemInstrutor>> listarInstrutores(
            @PageableDefault(size=5, sort={"nome"}) Pageable paginacao
    ) {
        Page<DadosListagemInstrutor> page = instrutorRepository.findAllByAtivoTrue(paginacao)
                                            .map(DadosListagemInstrutor::new);
        return ResponseEntity.ok(page);
    }

    @Transactional
    @PutMapping("/atualizar-cadastro")
    public ResponseEntity atualizarInstrutor(
            @RequestBody @Valid DadosAtualizacaoInstrutor dados
    ) {
        Instrutor instrutor = instrutorRepository.findByIdAndAtivoTrue(dados.id());
        instrutor.atualizarInformacoes(dados);
        return ResponseEntity.ok().body(new DadosDetalhamentoInstrutor(instrutor));
    }

    @Transactional
    @DeleteMapping("/apagar-instrutor/{id}")
    public ResponseEntity<Void> apagarInstrutor(@PathVariable Long id) {
        Instrutor instrutor = instrutorRepository.getReferenceById(id);
        instrutor.apagar();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/instrutor/{id}")
    public ResponseEntity detalharInstrutor(@PathVariable Long id) {
        Instrutor instrutor = instrutorRepository.findByIdAndAtivoTrue(id);
        return ResponseEntity.ok(new DadosDetalhamentoInstrutor(instrutor));
    }
}
