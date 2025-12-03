package br.com.senai.autoescola_n321.adapter.in.controller;

import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.endereco.DadosEndereco;
import br.com.senai.autoescola_n321.application.core.usecase.ViaCepService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cep")
@SecurityRequirement(name = "bearer-key")
public class ViaCepController {

    private final ViaCepService viaCepService;

    // TODO remover ViaCep
    public ViaCepController(ViaCepService viaCepService) {
        this.viaCepService = viaCepService;
    }

    @GetMapping("/{cep}")
    public ResponseEntity<DadosEndereco> buscarEndereco(@PathVariable String cep) {
        return ResponseEntity.ok(viaCepService.buscar(cep));
    }
}
