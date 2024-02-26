package br.com.teste.emprestimo.payload.req;

import jakarta.validation.constraints.Max;

public record NovoEmprestimoDto(String identificador, Double valorEmprestimo, @Max(value = 24, message = "O número de parcelas deve ser 24 ou menos") Integer numeroParcelas) {
}
