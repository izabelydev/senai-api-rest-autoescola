package br.com.senai.autoescola_n321.adapter.in.controller;

import br.com.senai.autoescola_n321.adapter.in.dto.instrutor.DadosCadastroInstrutor;
import br.com.senai.autoescola_n321.adapter.in.dto.instrutor.DadosListagemInstrutor;
import br.com.senai.autoescola_n321.adapter.out.domain.entity.Instrutor;
import br.com.senai.autoescola_n321.adapter.out.domain.repository.InstrutorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/instrutores")
public class InstrutorController {

    @Autowired
    private InstrutorRepository instrutorRepository;

    @PostMapping("/cadastrar")
    public void cadastrarInstrutor(@RequestBody @Valid DadosCadastroInstrutor dados) {
        instrutorRepository.save(new Instrutor(dados));
    }

    @GetMapping("/listar-instrutores")
    public Page<DadosListagemInstrutor> listarInstrutores(@PageableDefault(size=5, sort={"nome"}) Pageable paginacao) {
        return instrutorRepository.findAll(paginacao).map(DadosListagemInstrutor::new);
    }
}
