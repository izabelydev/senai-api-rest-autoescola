package br.com.senai.autoescola_n321.application.core.usecase;

import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.endereco.DadosEndereco;
import br.com.senai.autoescola_n321.adapter.out.viacep.mapper.ViaCepMapper;
import br.com.senai.autoescola_n321.application.ports.out.ViaCepPort;
import org.springframework.stereotype.Service;

@Service
public class ViaCepService {

    private final ViaCepMapper viaCepMapper;
    private final ViaCepPort viaCepPort;

    public ViaCepService(ViaCepMapper viaCepMapper, ViaCepPort viaCepPort) {
        this.viaCepMapper = viaCepMapper;
        this.viaCepPort = viaCepPort;
    }

    public DadosEndereco buscar(String cep) {
        return viaCepMapper.toDto(viaCepPort.buscarEnderecoPorCep(cep));
    }
}
