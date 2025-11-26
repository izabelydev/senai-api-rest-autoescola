package br.com.senai.autoescola_n321.adapter.in.controller.dto.response.viacep;

public record DadosViaCep(
   String cep,
   String logradouro,
   String complemento,
   String unidade,
   String bairro,
   String localidade,
   String uf,
   String estado,
   String regiao,
   String ibge,
   String gia,
   String ddd,
   String siafi
) {}
