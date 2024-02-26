package br.com.teste.emprestimo.repository;

import br.com.teste.emprestimo.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
