INSERT INTO EMPRESA (nome) VALUES('Razer');
INSERT INTO EMPRESA (nome) VALUES('Logitech');

INSERT INTO PROJETO (nome, status, data_ativacao, empresa_id) VALUES('Mouse', TRUE, '2019-01-01 00:00:00', 1);
INSERT INTO PROJETO (nome, status, data_ativacao, empresa_id) VALUES('Teclado', TRUE, '2019-01-01 00:00:00', 1);
INSERT INTO PROJETO (nome, status, data_ativacao, empresa_id) VALUES('Teclado', TRUE, '2019-01-01 00:00:00', 2);

INSERT INTO PROJETO (nome, status, data_ativacao, data_desativacao, empresa_id) VALUES('H7', FALSE, '2018-01-01 00:00:00','2019-01-01 00:00:00', 1);
INSERT INTO PROJETO (nome, status, data_ativacao, data_desativacao, empresa_id) VALUES('Mousepad', FALSE, '2019-01-02 00:00:00','2019-05-01 00:00:00', 1);





INSERT INTO USUARIO (nome, email, data_nascimento, status, apelido, empresa_id) VALUES('Igor', 'igor@igor.com', '2000-01-01 00:00:00', TRUE, 'Faze', 1);
INSERT INTO USUARIO (nome, email, data_nascimento, status, apelido, empresa_id) VALUES('Bianca', 'Bianca@Bianca.com', '2000-01-01 00:00:00', TRUE, 'Bianca', 1);
