# emprestimo

## Descrição
API para realizar empréstimos para pessoas físicas (PF), jurídica (PJ), estudante universitária (EU) e aposentada (AP).

## Requisitos técnicos
- Java 21+
- PostgreSQL

## Operações de pessoa
A pessoa é composta por ID único, nome, data de nascimento, identificador único, tipo de identificador, valor minímo
mensal das parcelas do empréstimo e valor máximo do empréstimo. Os dois últimos são definidos automaticamente a partir do
tipo do identificador.

### Cadastrar pessoa
Operação que realiza o cadastro da pessoa através do nome, data de nascimento e identificador.

**Endpoint:** `POST /pessoa`

**Requisição**
```json
{
  "nome": "Jusefa",
  "dataNascimento": "1985-03-10",
  "identificador": "70651032423"
}
```

**Resposta**
```json
{
	"id": 4,
	"nome": "Jusefa",
	"dataNascimento": "1985-03-10",
	"identificador": "70651032423",
	"tipoIdentificador": "PF",
	"valorMinMensal": 300.0,
	"valorMaxEmprestimo": 10000.0
}
```

### Buscar pessoa registrada a partir do identificador
Operação que realiza a busca de uma pessoa a partir do identificador informado.

**Endpoint:** `GET /pessoa?identificador=70651032423`

**Resposta**
```json
{
	"id": 4,
	"nome": "Jusefa",
	"dataNascimento": "1985-03-10",
	"identificador": "70651032423",
	"tipoIdentificador": "PF",
	"valorMinMensal": 300.0,
	"valorMaxEmprestimo": 10000.0
}
```

### Buscar todas as pessoas registradas
Semelhante a operação de buscar pessoa a partir do identificador, porém, caso não seja informado o identificador, então 
retorna todas as pessoas registradas na base de dados.

**Endpoint:** `GET /pessoa`

**Resposta**
```json
[
  {
    "id": 4,
    "nome": "Jusefa",
    "dataNascimento": "1985-03-10",
    "identificador": "70651032423",
    "tipoIdentificador": "PF",
    "valorMinMensal": 300.0,
    "valorMaxEmprestimo": 10000.0
  }
]
```

## Operações de empréstimo
O empréstimo é composto por ID único, data de criação, valor do empréstimo, número de parcelas, status e pessoa
vinculada, neste caso, quem solicitou o empréstimo.

### Cadastrar empréstimo
Operação que realiza o cadastro do empréstimo através do identificador do solicitante, valor do empréstimo e número de parcelas.

**Endpoint:** `POST /emprestimo`

**Requisição**
```json
{
  "identificador": "70651032423",
  "valorEmprestimo": 10000,
  "numeroParcelas": 20
}
```

**Resposta**
```json
{
  "id": 3,
  "dataCriacao": "2024-02-26",
  "valorEmprestimo": 10000.0,
  "numeroParcela": 20,
  "statusPagamento": "PAGO",
  "pessoa": {
    "id": 4,
    "nome": "Jusefa",
    "dataNascimento": "1985-03-10",
    "identificador": "70651032423",
    "tipoIdentificador": "PF",
    "valorMinMensal": 300.0,
    "valorMaxEmprestimo": 10000.0
  }
}
```

### Buscar todos os empréstimos registrados
Operação que realiza a busca de todos os empréstimos registrados na base de dados.

**Endpoint:** `GET /emprestimo`

**Resposta**
```json
[
  {
    "id": 3,
    "dataCriacao": "2024-02-26",
    "valorEmprestimo": 10000.0,
    "numeroParcela": 20,
    "statusPagamento": "PAGO",
    "pessoa": {
      "id": 4,
      "nome": "Jusefa",
      "dataNascimento": "1985-03-10",
      "identificador": "70651032423",
      "tipoIdentificador": "PF",
      "valorMinMensal": 300.0,
      "valorMaxEmprestimo": 10000.0
    }
  }
]
```