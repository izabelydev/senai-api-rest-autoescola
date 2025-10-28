CREATE TABLE tb_ins (
    ins_id      BIGINT       NOT NULL AUTO_INCREMENT,
    ins_nm      VARCHAR(100) NOT NULL,
    ins_eml     VARCHAR(100) NOT NULL UNIQUE,
    ins_cnh     VARCHAR(11)  NOT NULL,
    ins_esp     VARCHAR(20)  NOT NULL,
    ins_end_lgd VARCHAR(100) NOT NULL,
    ins_end_num VARCHAR(20),
    ins_end_cmp VARCHAR(100),
    ins_end_bai VARCHAR(100) NOT NULL,
    ins_end_cid VARCHAR(100) NOT NULL,
    ins_end_uf  VARCHAR(2)   NOT NULL,
    ins_end_cep VARCHAR(8)   NOT NULL,
    PRIMARY KEY(ins_id)
);

INSERT INTO tb_ins (
    ins_nm, ins_eml, ins_cnh, ins_esp,
    ins_end_lgd, ins_end_num, ins_end_cmp,
    ins_end_bai, ins_end_cid, ins_end_uf, ins_end_cep
) VALUES
('Eduardo Santos', 'eduardosantos@autoescola.com.br', '01134567890', 'CARROS',
 'Rua Ibó', '300', 'Apto. 91', 'Vila Regente Feijó', 'São Paulo', 'SP', '03346000'),

('Mariana Oliveira', 'mariana.oliveira@autoescola.com.br', '02298765432', 'MOTOS',
 'Avenida Paulista', '1578', 'Bloco B', 'Bela Vista', 'São Paulo', 'SP', '01310100'),

('Carlos Souza', 'carlos.souza@autoescola.com.br', '03312345678', 'CARROS',
 'Rua das Acácias', '45', NULL, 'Jardim das Flores', 'Campinas', 'SP', '13050010'),

('Fernanda Lima', 'fernanda.lima@autoescola.com.br', '04498712345', 'CAMINHÕES',
 'Rua Getúlio Vargas', '120', 'Casa 2', 'Centro', 'Curitiba', 'PR', '80010050'),

('Lucas Almeida', 'lucas.almeida@autoescola.com.br', '05511122233', 'VANS',
 'Avenida Atlântica', '999', 'Ap 34', 'Copacabana', 'Rio de Janeiro', 'RJ', '22021001'),

('Patrícia Ribeiro', 'patricia.ribeiro@autoescola.com.br', '06622233344', 'CARROS',
 'Rua XV de Novembro', '250', 'Fundos', 'Centro', 'Blumenau', 'SC', '89010001'),

('Rodrigo Martins', 'rodrigo.martins@autoescola.com.br', '07733344455', 'MOTOS',
 'Rua Dom Pedro II', '87', NULL, 'Jardim América', 'Goiânia', 'GO', '74020030'),

('Juliana Costa', 'juliana.costa@autoescola.com.br', '08844455566', 'CARROS',
 'Avenida das Nações', '1500', 'Ap 1002', 'Setor Bueno', 'Goiânia', 'GO', '74210010'),

('André Pereira', 'andre.pereira@autoescola.com.br', '09955566677', 'CAMINHÕES',
 'Rua Floriano Peixoto', '200', NULL, 'Centro', 'Belo Horizonte', 'MG', '30110040'),

('Renata Carvalho', 'renata.carvalho@autoescola.com.br', '10066677788', 'CARROS',
 'Rua das Palmeiras', '123', 'Casa A', 'Santa Rosa', 'Niterói', 'RJ', '24220050'),

('Thiago Nunes', 'thiago.nunes@autoescola.com.br', '11177788899', 'VANS',
 'Avenida Brasil', '8000', NULL, 'Ramos', 'Rio de Janeiro', 'RJ', '21031200'),

('Camila Torres', 'camila.torres@autoescola.com.br', '12288899900', 'MOTOS',
 'Rua João Pessoa', '67', 'Casa 1', 'Centro', 'Porto Alegre', 'RS', '90010120'),

('Bruno Ferreira', 'bruno.ferreira@autoescola.com.br', '13399900011', 'CARROS',
 'Rua Sete de Setembro', '444', NULL, 'Centro', 'Recife', 'PE', '50060030'),

('Ana Paula Mendes', 'ana.mendes@autoescola.com.br', '14400011122', 'CARROS',
 'Rua Goiás', '12', 'Ap 204', 'Funcionários', 'Belo Horizonte', 'MG', '30150150'),

('Gabriel Barbosa', 'gabriel.barbosa@autoescola.com.br', '15511122233', 'MOTOS',
 'Avenida Independência', '901', NULL, 'Centro', 'Porto Alegre', 'RS', '90035070');

