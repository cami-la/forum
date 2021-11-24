
CREATE TABLE topico (
    id bigint NOT NULL,
    titulo varchar(50) NOT NULL,
    mensagem varchar(300) NOT NULL,
    data_criacao datetime NOT NULL,
    status varchar(20) NOT NULL,
    curso_id bigint NOT NULL,
    autor_id bigint NOT NULL,
    primary key(id),
    foreign key(curso_id) REFERENCES curso(id),
    foreign key(autor_id) REFERENCES usuario(id)

    primary key(id)
);
