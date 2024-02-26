package br.com.teste.emprestimo.exception;

public class BusinessException extends RuntimeException {
  private String campo;
  public BusinessException(String msg, String campo) {
    super(msg);
    this.campo = campo;
  }

  public String getCampo() {
    return campo;
  }
}
