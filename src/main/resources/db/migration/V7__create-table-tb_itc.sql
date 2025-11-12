CREATE TABLE tb_itc (
    itc_id      BIGINT   NOT NULL AUTO_INCREMENT,
    itc_alu_id  BIGINT   NOT NULL,
    itc_ins_id  BIGINT   NOT NULL,
    itc_dt      DATETIME NOT NULL,
    itc_can     TINYINT  DEFAULT 0,

    PRIMARY KEY(itc_id),
    CONSTRAINT fk_itc_alu_id FOREIGN KEY(itc_alu_id) REFERENCES tb_alu(alu_id),
    CONSTRAINT fk_itc_ins_id FOREIGN KEY(itc_ins_id) REFERENCES tb_ins(ins_id)
);