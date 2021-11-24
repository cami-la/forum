
CREATE TABLE resposta (
    id bigint NOT NULL,
    mensagem varchar(300) NOT NULL,
    data_criacao datetime NOT NULL,
    topico_id bigint NOT NULL,
    autor_id bigint NOT NULL,
    solucao int(1) NOT NULL,
    primary key(id),
    foreign key(topico_id) REFERENCES topico(id),
    foreign key(autor_id) REFERENCES usuario(id)
);
