package br.com.teste.emprestimo.enums;

import java.math.BigDecimal;

public enum TipoIdentificadorEnum {
  PF("PF", 11, "Pessoa Física (PF)", BigDecimal.valueOf(300), BigDecimal.valueOf(10000)),
  PJ("PJ", 14, "Pessoa Jurídica (PJ)", BigDecimal.valueOf(1000), BigDecimal.valueOf(100000)),
  EU("EU", 8, "Estudante Universitário (EU)", BigDecimal.valueOf(100), BigDecimal.valueOf(10000)),
  AP("AP", 10, "Aposentado (AP)", BigDecimal.valueOf(400), BigDecimal.valueOf(2500000));

  private String codigo;
  private int tamanho;
  private String descricao;
  private BigDecimal vlrMinMensal;
  private BigDecimal vlrMaxEmprestimo;

  TipoIdentificadorEnum(String codigo, int tamanho, String descricao, BigDecimal vlrMinMensal, BigDecimal vlrMaxEmprestimo) {
    this.codigo = codigo;
    this.tamanho = tamanho;
    this.descricao = descricao;
    this.vlrMinMensal = vlrMinMensal;
    this.vlrMaxEmprestimo = vlrMaxEmprestimo;
  }

  public String getCodigo() {
    return codigo;
  }

  public int getTamanho() {
    return tamanho;
  }

  public String getDescricao() {
    return descricao;
  }

  public BigDecimal getVlrMinMensal() {
    return vlrMinMensal;
  }

  public BigDecimal getVlrMaxEmprestimo() {
    return vlrMaxEmprestimo;
  }

  public static TipoIdentificadorEnum procurarPorTamanho(int tamanho) {
    for (TipoIdentificadorEnum tie : TipoIdentificadorEnum.values()) {
      if (tamanho == tie.getTamanho()) return tie;
    }

    return null;
  }
}
