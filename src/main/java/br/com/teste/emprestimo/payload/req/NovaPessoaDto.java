package br.com.teste.emprestimo.payload.req;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record NovaPessoaDto(@NotBlank(message = "O nome da pessoa é obrigatório") String nome,
                            @NotNull(message = "A data de nascimento da pessoa é obrigatório") LocalDate dataNascimento,
                            @NotBlank(message = "O idenficador da pessoa é obrigatório") String identificador) {

}
