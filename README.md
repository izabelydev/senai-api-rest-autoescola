# SENAI API REST autoescola

### Configuracoes do projeto:

| Tecnologia | Versao |
|------------|--------|
| Java       | 25.0.1 |
| Maven      | 4.0.0  |
| SpringBoot | 3.5.6  |

### Cadastrar Instrutor

Metodo POST: http://localhost:8085/instrutores/cadastrar

Body: 
``` json
{
	"nome": "Carlos Eduardo",
	"email": "carlosoliver@autoescola.com.br",
	"cnh": "01234567890",
	"especialidade": "CARROS",
	"endereco": {
		"cep": "03346000",
		"logradouro": "Rua Ibó",
		"numero": "300",
		"bairro": "Vila Regente Feijó",
		"complemento": "Apto. 91",
		"cidade": "São Paulo",
		"uf": "SP"
	}
}
```