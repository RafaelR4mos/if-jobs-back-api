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

