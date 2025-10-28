CREATE TABLE instrutores(
    id              BIGINT NOT NULL  AUTO_INCREMENT,
    nome            varchar(100) NOT NULL ,
    email           varchar(100) NOT NULL unique,
    cnh             varchar(11)  NOT NULL unique,
    especialidade   varchar(20)  not null,
    logradouro      varchar(100) not null,
    numero          varchar(20),
    complemento     varchar(100),
    bairro          varchar(100) not null,
    cidade          varchar(100) not null,
    uf              varchar(2)   not null,
    cep             varchar(10)  not null,

   PRIMARY KEY (id)
);