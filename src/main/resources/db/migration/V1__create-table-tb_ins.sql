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
