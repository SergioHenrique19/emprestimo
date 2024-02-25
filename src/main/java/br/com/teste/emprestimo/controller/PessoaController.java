package br.com.teste.emprestimo.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
@RequestMapping("/pessoa")
@AllArgsConstructor
public class PessoaController {

  private final RestClient restClient = RestClient.create();

  @GetMapping("/{cpf}")
  public ResponseEntity<Object> validaCpf(@PathVariable String cpf) {
    var res = restClient.get().uri("https://api-validador-cpf.vercel.app/validarcpf/" + cpf).retrieve().body(String.class);

    return new ResponseEntity<>(res, HttpStatus.OK);
  }
}
