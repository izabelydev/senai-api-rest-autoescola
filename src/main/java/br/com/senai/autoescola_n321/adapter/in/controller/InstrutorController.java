package br.com.senai.autoescola_n321.adapter.in.controller;

import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.instrutor.DadosAtualizacaoInstrutor;
import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.instrutor.DadosCadastroInstrutor;
import br.com.senai.autoescola_n321.adapter.in.controller.dto.response.instrutor.DadosDetalhamentoInstrutor;
import br.com.senai.autoescola_n321.adapter.in.controller.dto.response.instrutor.DadosListagemInstrutor;
import br.com.senai.autoescola_n321.application.core.domain.model.Instrutor;
import br.com.senai.autoescola_n321.application.core.usecase.InstrutorService;
import br.com.senai.autoescola_n321.exception.types.business.InstrutorNaoExisteException;
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
@RequestMapping("/instrutores")
public class InstrutorController {

    private final InstrutorService instrutorService;

    public InstrutorController(InstrutorService instrutorService) {
        this.instrutorService = instrutorService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<DadosDetalhamentoInstrutor> cadastrarInstrutor(
            @RequestBody @Valid DadosCadastroInstrutor dados,
            UriComponentsBuilder uriBuilder
    ) {
        DadosDetalhamentoInstrutor dto = instrutorService.cadastrar(dados);
        URI uri = uriBuilder.path("/instrutores/instrutor/{id}").buildAndExpand(dto.id()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

//    @GetMapping("/listar-instrutores")
//    public ResponseEntity<Page<DadosListagemInstrutor>> listarInstrutores(
//            @PageableDefault(size=5, sort={"nome"}) Pageable paginacao
//    ) {
//        Page<DadosListagemInstrutor> page = instrutorRepository.findAllByAtivoTrue(paginacao)
//                                            .map(DadosListagemInstrutor::new);
//        return ResponseEntity.ok(page);
//    }
//
//    @Transactional
//    @PutMapping("/atualizar-cadastro")
//    public ResponseEntity<DadosDetalhamentoInstrutor> atualizarInstrutor (
//            @RequestBody @Valid DadosAtualizacaoInstrutor dados
//    ) {
//        Instrutor instrutor = instrutorService.getInstrutor(dados.id());
//        instrutor.atualizarInformacoes(dados);
//        instrutorRepository.save(instrutor);
//        return ResponseEntity.ok(new DadosDetalhamentoInstrutor(instrutor));
//    }
//
//    @Transactional
//    @DeleteMapping("/apagar-instrutor/{id}")
//    public ResponseEntity<Void> apagarInstrutor(@PathVariable Long id) {
//        Instrutor instrutor = instrutorService.getInstrutor(id);
//        instrutor.apagar();
//        instrutorRepository.save(instrutor);
//        return ResponseEntity.noContent().build();
//    }
//
//    @GetMapping("/instrutor/{id}")
//    public ResponseEntity<DadosDetalhamentoInstrutor> detalharInstrutor(@PathVariable Long id) {
//        Instrutor instrutor = instrutorRepository.findById(id)
//                .orElseThrow(() -> new InstrutorNaoExisteException("Instrutor não existe."));
//        return ResponseEntity.ok(new DadosDetalhamentoInstrutor(instrutor));
//    }
}
