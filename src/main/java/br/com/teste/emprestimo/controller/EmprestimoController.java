package br.com.teste.emprestimo.controller;

import br.com.teste.emprestimo.payload.req.NovoEmprestimoDto;
import br.com.teste.emprestimo.service.EmprestimoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emprestimo")
@AllArgsConstructor
public class EmprestimoController {

  private final EmprestimoService emprestimoService;

  @PostMapping
  public ResponseEntity<Object> cadastrarPessoa(@RequestBody @Valid NovoEmprestimoDto novoEmprestimoDto) {
    return new ResponseEntity<>(emprestimoService.cadastrarEmprestimo(novoEmprestimoDto), HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<Object> buscarEmprestimos() {
    return new ResponseEntity<>(emprestimoService.buscarEmprestimos(), HttpStatus.OK);
  }

}
