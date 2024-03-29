CREATE EXTENSION IF NOT EXISTS CITEXT;

CREATE TABLE IF NOT EXISTS pessoa (
  id SERIAL PRIMARY KEY,
  nome VARCHAR(50) NOT NULL,
  data_nascimento DATE NOT NULL,
  identificador VARCHAR(50) NOT NULL,
  tipo_identificador VARCHAR(50) NOT NULL,
  valor_min_mensal DECIMAL(18,4) NOT NULL,
  valor_max_emprestimo DECIMAL(18,4) NOT NULL
);

CREATE TABLE IF NOT EXISTS emprestimo (
  id SERIAL PRIMARY KEY,
  data_criacao DATE NOT NULL DEFAULT CURRENT_DATE,
  valor_emprestimo DECIMAL(18,4) NOT NULL,
  numero_parcela INT NOT NULL,
  status_pagamento VARCHAR(50) NOT NULL,
  pessoa_id INTEGER,
  CONSTRAINT fk_pessoa
    FOREIGN KEY(pessoa_id)
      REFERENCES pessoa(id)
);