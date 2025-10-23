package br.com.senai.autoescola_n321.controller;

import br.com.senai.autoescola_n321.entity.instrutor.DadosCadastroInstrutor;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/instrutores")
public class InstrutorController {

    @PostMapping("/cadastrar")
    public void cadastrarInstrutor(@RequestBody @Valid DadosCadastroInstrutor dados) {
        System.out.printf(dados.especialidade().toString());
    }
}
