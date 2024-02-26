package br.com.teste.emprestimo.payload.res;

import java.time.LocalDate;

public record PessoaDto(Long id, String nome, LocalDate dataNascimento, String identificador, String tipoIdentificador,
                        Double valorMinMensal, Double valorMaxEmprestimo) {
}
