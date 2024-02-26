package br.com.teste.emprestimo.enums;

public enum TipoIdentificadorEnum {
  PF("PF", 11, 300.0, 10000.0),
  PJ("PJ", 14, 1000.0, 100000.0),
  EU("EU", 8, 100.0, 10000.0),
  AP("AP", 10, 400.0, 2500000.0);

  private String codigo;
  private int tamanho;
  private Double vlrMinMensal;
  private Double vlrMaxEmprestimo;

  TipoIdentificadorEnum(String codigo, int tamanho, Double vlrMinMensal, Double vlrMaxEmprestimo) {
    this.codigo = codigo;
    this.tamanho = tamanho;
    this.vlrMinMensal = vlrMinMensal;
    this.vlrMaxEmprestimo = vlrMaxEmprestimo;
  }

  public String getCodigo() {
    return codigo;
  }

  public int getTamanho() {
    return tamanho;
  }

  public Double getVlrMinMensal() {
    return vlrMinMensal;
  }

  public Double getVlrMaxEmprestimo() {
    return vlrMaxEmprestimo;
  }

  public static TipoIdentificadorEnum procurarPorTamanho(int tamanho) {
    for (TipoIdentificadorEnum tie : TipoIdentificadorEnum.values()) {
      if (tamanho == tie.getTamanho()) return tie;
    }

    return null;
  }

  public static TipoIdentificadorEnum procurarPorCodigo(String codigo) {
    for (TipoIdentificadorEnum tie : TipoIdentificadorEnum.values()) {
      if (codigo.equals(tie.getCodigo())) return tie;
    }

    return null;
  }
}
