package br.com.teste.emprestimo.repository;

import br.com.teste.emprestimo.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
  @Query(value = "select * from pessoa where identificador = :identificador", nativeQuery = true)
  Pessoa findByIdentificador(String identificador);
}
