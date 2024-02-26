package br.com.teste.emprestimo.payload.res;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PessoaDto(Long id, String nome, LocalDate dataNascimento, String identificador, String tipoIdentificador,
                        BigDecimal valorMinMensal, BigDecimal valorMaxEmprestimo) {
}
