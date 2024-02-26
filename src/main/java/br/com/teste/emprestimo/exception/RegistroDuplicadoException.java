package br.com.teste.emprestimo.exception;

public class RegistroDuplicadoException extends RuntimeException {
  public RegistroDuplicadoException(String msg) {
    super(msg);
  }
}
