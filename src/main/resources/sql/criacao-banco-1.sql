create table ifjobs.TB_ENDERECOS (
	id_endereco INTEGER not null primary key,
	cep VARCHAR(20) not null,
	numero VARCHAR(20) not null,
	logradouro VARCHAR(200) not null,
	cidade VARCHAR(200) not null,
	bairro VARCHAR(200),
	uf char(2) not null,
	complemento VARCHAR(200)
);

CREATE SEQUENCE seq_enderecos
    INCREMENT BY 1
    START WITH 1
    MINVALUE 1
    NO MAXVALUE
    CYCLE;


create table ifjobs.TB_EMPRESAS (
	id_empresa INTEGER not null primary key,
	cnpj_empresa VARCHAR(20) not null unique,
	nm_empresa VARCHAR(200) not null,
	id_endereco INTEGER,
	desc_empresa VARCHAR(255),
	status_empresa INTEGER not null default 0,
	created_at TIMESTAMPTZ not null default current_timestamp,
	updated_at TIMESTAMPTZ,
	foreign key (id_endereco) references TB_ENDERECOS(id_endereco)
);

CREATE SEQUENCE seq_empresas
    INCREMENT BY 1
    START WITH 1
    MINVALUE 1
    NO MAXVALUE
    CYCLE;


create table ifjobs.TB_VAGAS (
    id_vaga INTEGER not null primary key,
    id_empresa INTEGER,
    id_endereco INTEGER,
    nm_vaga VARCHAR(200) not null,
    desc_vaga VARCHAR(200) not null,
    tipo_jornada INTEGER not null,
    status_vaga INTEGER not null default 0,
    created_at TIMESTAMPTZ not null default CURRENT_TIMESTAMP,
    updated_at TIMESTAMPTZ,
    foreign key (id_empresa) references TB_EMPRESAS(id_empresa),
    foreign key (id_endereco) references TB_ENDERECOS(id_endereco)
);

CREATE SEQUENCE seq_vagas
    INCREMENT BY 1
    START WITH 1
    MINVALUE 1
    NO MAXVALUE
    CYCLE;

-- NOVAS TABELAS 21/10

CREATE TABLE TB_USUARIOS (
    id_usuario VARCHAR(40) NOT NULL PRIMARY KEY,
    login_usuario VARCHAR(255) NOT NULL UNIQUE,
    cpf_usuario VARCHAR(12) NOT NULL UNIQUE,
    senha_usuario VARCHAR(30) NOT NULL,
    nm_usuario VARCHAR(255) NOT NULL,
    dt_nascimento DATE NOT NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMPTZ
);

CREATE TABLE TB_CURSOS (
    id_curso INTEGER NOT NULL PRIMARY KEY,
    qtd_semestres INTEGER NOT NULL,
    nm_curso VARCHAR(200) NOT NULL
);

CREATE SEQUENCE seq_cursos
    INCREMENT BY 1
    START WITH 1
    MINVALUE 1
    NO MAXVALUE
    CYCLE;

CREATE TABLE TB_ALUNOS(
    id_aluno VARCHAR(40) NOT NULL PRIMARY KEY,
    id_usuario VARCHAR(40) NOT NULL,
    matricula_aluno VARCHAR(30) NOT NULL UNIQUE,
    email_academico VARCHAR(255) NOT NULL UNIQUE,
    id_curso INTEGER DEFAULT NULL,
    semestre_referencia INT NOT NULL DEFAULT 1,
    cr_aluno INTEGER DEFAULT 0,
    data_matricula TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_curso) REFERENCES TB_CURSOS(id_curso)
    FOREIGN KEY (id_usuario) REFERENCES TB_USUARIOS(id_usuario)
);

CREATE TABLE TB_CANDIDATURAS (
    id_aluno VARCHAR(40) NOT NULL PRIMARY KEY,
    id_vaga INTEGER NOT NULL,
    dt_inscricao TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    status_candidatura NOT NULL INTEGER DEFAULT 0,
    curriculo BYTEA NOT NULL
    FOREIGN KEY(id_aluno) REFERENCES TB_ALUNOS(id_aluno),
    FOREIGN KEY(id_vaga) REFERENCES TB_VAGAS(id_vaga)
);

ALTER TABLE TB_ALUNOS ADD COLUMN id_usuario VARCHAR(40) NOT NULL

ALTER TABLE TB_ALUNOS ADD CONSTRAINT fk_id_usuario FOREIGN KEY (id_usuario) REFERENCES TB_USUARIOS(id_usuario);