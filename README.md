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

**Versao MySQL**: mysql-installer-web-community-8.0.43.0

**Nome do banco de dados**: dbnautoescolan321

**Porta**: 3306

**Variaveis de ambiente**:

```
DBN_URL=jdbc:mysql://localhost/dbnautoescolan321;
DBN_USER=seu_usuario;
DBN_PASSWORD=sua_senha;
```

---

### Cadastrar Instrutor

Com o Insomnia ou PostMan usar o método POST na rota abaixo:
```
http://localhost:8085/instrutores/cadastrar
```

**Body**: 
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

### Listar instrutores

Com o Insomnia ou PostMan usar o método GET na rota abaixo:
```
http://localhost:8085/instrutores/listar-instrutores
```

Por padrão, a paginacao e feita com tamanho 5 e ordenado por nome em ordem alfabética
```java
@PageableDefault(size=5, sort={"nome"})
```

Mas caso queira mudar esse comportamento, use a url abaixo com os parametros personalizados:
```
http://localhost:8085/instrutores/listar-instrutores?sort=nome&page=0&size=10
```

