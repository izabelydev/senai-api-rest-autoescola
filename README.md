# SENAI API REST autoescola

---

### Configurações do projeto:

| Tecnologia | Versao |
|------------|--------|
| Java       | 25.0.1 |
| Maven      | 4.0.0  |
| SpringBoot | 3.5.6  |

---

### Configurar conexão com banco de dados

Versao MySQL: mysql-installer-web-community-8.0.43.0

Nome do banco de dados: dbnautoescolan321

Porta: 3306

Variaveis de ambiente:

```
DBN_USER=seu_usuario;
DBN_PASSWORD=sua_senha;
```

---

### Cadastrar Instrutor

Com o Insomnia ou PostMan usar o método POST na rota abaixo:
http://localhost:8085/instrutores/cadastrar

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

---

