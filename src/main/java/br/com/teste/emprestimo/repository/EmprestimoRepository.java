package br.com.teste.emprestimo.repository;

import br.com.teste.emprestimo.entity.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
}
