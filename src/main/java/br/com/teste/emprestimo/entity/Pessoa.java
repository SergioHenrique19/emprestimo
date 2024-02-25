package br.com.teste.emprestimo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "pessoa")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pessoa {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;

  @Column(name = "data_nascimento")
  private LocalDate dataNascimento;

  private String identificador;

  @Column(name = "tipo_identificador")
  private String tipoIdentificador;

  @Column(name = "valor_min_mensal")
  private BigDecimal valorMinMensal;

  @Column(name = "valor_max_emprestimo")
  private BigDecimal valorMaxEmprestimo;
}