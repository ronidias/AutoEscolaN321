create table usuarios (
    id BIGINT NOT NULL AUTO_INCREMENT,
    login varchar(100) not null,
    senha varchar(255) not null,

    primary key (id)
);