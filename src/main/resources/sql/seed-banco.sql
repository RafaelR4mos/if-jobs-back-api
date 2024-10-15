DELETE FROM ifjobs.TB_VAGAS CASCADE;
DELETE FROM ifjobs.TB_EMPRESAS CASCADE;
DELETE FROM ifjobs.TB_ENDERECOS CASCADE;


ALTER SEQUENCE ifjobs.seq_empresas RESTART WITH 1;
ALTER SEQUENCE ifjobs.seq_enderecos RESTART WITH 1;
ALTER SEQUENCE ifjobs.seq_vagas RESTART WITH 1;

--TB ENDERECO

INSERT INTO ifjobs.TB_ENDERECOS (id_endereco, cep, numero, logradouro, cidade, bairro, uf, complemento)
VALUES (nextval('seq_enderecos'), '12345-678', '100', 'Rua Principal', 'São Paulo', 'Centro', 'SP', 'Apartamento 10');

INSERT INTO ifjobs.TB_ENDERECOS (id_endereco, cep, numero, logradouro, cidade, bairro, uf, complemento)
VALUES (nextval('seq_enderecos'), '98765-432', '200', 'Avenida Secundária', 'Rio de Janeiro', 'Copacabana', 'RJ', 'Sala 5');

INSERT INTO ifjobs.TB_ENDERECOS (id_endereco, cep, numero, logradouro, cidade, bairro, uf, complemento)
VALUES (nextval('seq_enderecos'), '54321-123', '300', 'Travessa das Flores', 'Belo Horizonte', 'Savassi', 'MG', 'Casa 2');

-- TB EMPRESAS
INSERT INTO ifjobs.TB_EMPRESAS (id_empresa, cnpj_empresa, nm_empresa, id_endereco, desc_empresa, status_empresa, created_at, updated_at)
VALUES (nextval('seq_empresas'), '12.345.678/0001-99', 'Empresa Alpha', 1, 'Empresa de Tecnologia', 1, CURRENT_TIMESTAMP, NULL);

INSERT INTO ifjobs.TB_EMPRESAS (id_empresa, cnpj_empresa, nm_empresa, id_endereco, desc_empresa, status_empresa, created_at, updated_at)
VALUES (nextval('seq_empresas'), '98.765.432/0001-88', 'Empresa Beta', 2, 'Consultoria Financeira', 1, CURRENT_TIMESTAMP, NULL);

INSERT INTO ifjobs.TB_EMPRESAS (id_empresa, cnpj_empresa, nm_empresa, id_endereco, desc_empresa, status_empresa, created_at, updated_at)
VALUES (nextval('seq_empresas'), '11.111.111/0001-11', 'Empresa Gama', 3, 'Serviços de Marketing', 1, CURRENT_TIMESTAMP, NULL);


-- TB VAGAS
INSERT INTO ifjobs.TB_VAGAS (id_vaga, id_empresa, id_endereco, nm_vaga, desc_vaga, tipo_jornada, status_vaga, created_at, updated_at)
VALUES (nextval('seq_vagas'), 1, 1, 'Desenvolvedor Java', 'Vaga para desenvolvedor backend com experiência em Java', 1, 1, CURRENT_TIMESTAMP, NULL);

INSERT INTO ifjobs.TB_VAGAS (id_vaga, id_empresa, id_endereco, nm_vaga, desc_vaga, tipo_jornada, status_vaga, created_at, updated_at)
VALUES (nextval('seq_vagas'), 2, 2, 'Analista Financeiro', 'Vaga para analista financeiro com experiência em controladoria', 0, 1, CURRENT_TIMESTAMP, NULL);

INSERT INTO ifjobs.TB_VAGAS (id_vaga, id_empresa, id_endereco, nm_vaga, desc_vaga, tipo_jornada, status_vaga, created_at, updated_at)
VALUES (nextval('seq_vagas'), 3, 3, 'Gerente de Marketing', 'Vaga para gerente de marketing com foco em campanhas digitais', 2, 2, CURRENT_TIMESTAMP, NULL);

