package br.com.senai.autoescola_n321.adapter.in.controller;

import br.com.senai.autoescola_n321.adapter.in.dto.instrutor.DadosAtualizacaoInstrutor;
import br.com.senai.autoescola_n321.adapter.in.dto.instrutor.DadosCadastroInstrutor;
import br.com.senai.autoescola_n321.adapter.in.dto.instrutor.DadosListagemInstrutor;
import br.com.senai.autoescola_n321.adapter.out.domain.entity.Instrutor;
import br.com.senai.autoescola_n321.adapter.out.domain.repository.InstrutorRepository;
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
@RequestMapping("/instrutores")
public class InstrutorController {

    @Autowired
    private InstrutorRepository instrutorRepository;

    @Transactional
    @PostMapping("/cadastrar")
    public void cadastrarInstrutor(@RequestBody @Valid DadosCadastroInstrutor dados) {
        instrutorRepository.save(new Instrutor(dados));
    }

    @GetMapping("/listar-instrutores")
    public Page<DadosListagemInstrutor> listarInstrutores(@PageableDefault(size=5, sort={"nome"}) Pageable paginacao) {
        return instrutorRepository.findAllByAtivoTrue(paginacao).map(DadosListagemInstrutor::new);
    }

    @Transactional
    @PutMapping("/atualizar-cadastro")
    public void atualizarInstrutor(@RequestBody @Valid DadosAtualizacaoInstrutor dados) {
        Instrutor instrutor = instrutorRepository.getReferenceById(dados.id());
        instrutor.atualizarInformacoes(dados);
    }

    @Transactional
    @DeleteMapping("/apagar-instrutor/{id}")
    public void apagarInstrutor(@PathVariable Long id) {
        Instrutor instrutor = instrutorRepository.getReferenceById(id);
        instrutor.apagar();
    }
}
