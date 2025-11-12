CREATE TABLE tb_usu (
    usu_id     BIGINT       NOT NULL AUTO_INCREMENT,
    usu_atv    TINYINT      DEFAULT 1,
    usu_lg     VARCHAR(100) NOT NULL,
    usu_sn     VARCHAR(255) NOT NULL,
    PRIMARY KEY(usu_id)
);