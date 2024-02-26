package br.com.teste.emprestimo.controller;

import br.com.teste.emprestimo.payload.req.NovaPessoaDto;
import br.com.teste.emprestimo.service.PessoaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoa")
@AllArgsConstructor
public class PessoaController {

  private final PessoaService pessoaService;

  @PostMapping
  public ResponseEntity<Object> cadastrarPessoa(@RequestBody @Valid NovaPessoaDto novaPessoaDto) {
    return new ResponseEntity<>(pessoaService.cadastrarPessoa(novaPessoaDto), HttpStatus.CREATED);
  }

}
