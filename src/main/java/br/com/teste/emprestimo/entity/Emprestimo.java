package br.com.teste.emprestimo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "emprestimo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Emprestimo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "data_criacao")
  private LocalDate dataCriacao;

  @Column(name = "valor_emprestimo")
  private Double valorEmprestimo;

  @Column(name = "numero_parcela")
  private Integer numeroParcela;

  @Column(name = "status_pagamento")
  private String statusPagamento;

  @ManyToOne
  @JoinColumn(name = "pessoa_id", referencedColumnName = "id", nullable = false)
  @Getter
  @Setter
  private Pessoa pessoa;
}
