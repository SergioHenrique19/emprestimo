package br.com.teste.emprestimo.payload.res;

import java.math.BigDecimal;
import java.time.LocalDate;

public record EmprestimoDto(Long id, LocalDate dataCriacao, Double valorEmprestimo, Integer numeroParcela, String statusPagamento, PessoaDto pessoa) {
}
