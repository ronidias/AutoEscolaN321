CREATE TABLE instrucoes(
    id              BIGINT NOT NULL AUTO_INCREMENT,
    aluno_id        BIGINT NOT NULL,
    instrutor_id    BIGINT NOT NULL,
    data            DATETIME NOT NULL,
    cancelada       TINYINT NOT NULL DEFAULT 0,

    PRIMARY KEY(id),
    CONSTRAINT fk_instrucoes_aluno_id FOREIGN KEY(aluno_id) REFERENCES alunos(id),
    CONSTRAINT fk_instrucoes_instrutor_id FOREIGN KEY(instrutor_id) REFERENCES instrutores(id)
)