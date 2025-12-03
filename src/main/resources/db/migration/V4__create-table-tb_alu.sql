CREATE TABLE tb_alu (
    alu_id      BIGINT       NOT NULL AUTO_INCREMENT,
    alu_atv     TINYINT      DEFAULT 1,
    alu_nm      VARCHAR(100) NOT NULL,
    alu_eml     VARCHAR(100) NOT NULL UNIQUE,
    alu_tel     VARCHAR(20) NOT NULL,
    alu_cpf     VARCHAR(15)  NOT NULL,
    alu_end_lgd VARCHAR(100) NOT NULL,
    alu_end_num VARCHAR(20),
    alu_end_cmp VARCHAR(100),
    alu_end_bai VARCHAR(100) NOT NULL,
    alu_end_cid VARCHAR(100) NOT NULL,
    alu_end_uf  VARCHAR(2)   NOT NULL,
    alu_end_cep VARCHAR(8)   NOT NULL,
    PRIMARY KEY(alu_id)
);
