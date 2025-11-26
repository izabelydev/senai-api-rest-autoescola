package br.com.senai.autoescola_n321.adapter.out.viacep;

import br.com.senai.autoescola_n321.adapter.in.controller.dto.response.viacep.DadosEnderecoViaCep;
import br.com.senai.autoescola_n321.adapter.in.controller.dto.response.viacep.DadosViaCep;
import br.com.senai.autoescola_n321.adapter.out.viacep.mapper.ViaCepMapper;
import br.com.senai.autoescola_n321.application.ports.out.ViaCepPort;
import com.google.gson.Gson;
import org.apache.http.client.fluent.Request;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ViaCepImpl implements ViaCepPort {

    private final String URL = "https://viacep.com.br/ws/%s/json/";

    private final ViaCepMapper viaCepMapper;

    public ViaCepImpl(ViaCepMapper viaCepMapper) {
        this.viaCepMapper = viaCepMapper;
    }


    @Override
    public DadosEnderecoViaCep buscarEnderecoPorCep(String cep) {
        try {
            String jsonResponse = Request.Get(URL.formatted(cep))
                    .connectTimeout(10000)
                    .socketTimeout(10000)
                    .execute()
                    .returnContent()
                    .asString();

            DadosViaCep viaCep = new Gson().fromJson(jsonResponse, DadosViaCep.class);
            return viaCepMapper.toResponse(viaCep);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao buscar endereço: " + e.getMessage(), e);
        }
    }
}
