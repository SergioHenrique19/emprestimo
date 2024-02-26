package br.com.teste.emprestimo.mapper;

import br.com.teste.emprestimo.entity.Emprestimo;
import br.com.teste.emprestimo.entity.Pessoa;
import br.com.teste.emprestimo.enums.TipoIdentificadorEnum;
import br.com.teste.emprestimo.payload.req.NovaPessoaDto;
import br.com.teste.emprestimo.payload.req.NovoEmprestimoDto;
import br.com.teste.emprestimo.payload.res.EmprestimoDto;
import br.com.teste.emprestimo.payload.res.PessoaDto;

import java.time.LocalDate;

public class EmprestimoMapper {
  public static Emprestimo toEmprestimo(NovoEmprestimoDto novoEmprestimoDto, Pessoa pessoa) {
    var emprestimo = new Emprestimo();
    emprestimo.setDataCriacao(LocalDate.now());
    emprestimo.setValorEmprestimo(novoEmprestimoDto.valorEmprestimo());
    emprestimo.setNumeroParcela(novoEmprestimoDto.numeroParcelas());
    emprestimo.setStatusPagamento("PAGO");
    emprestimo.setPessoa(pessoa);

    return emprestimo;
  }

  public static EmprestimoDto toEmprestimoDto(Emprestimo emprestimo, PessoaDto pessoaDto) {
    return new EmprestimoDto(emprestimo.getId(), emprestimo.getDataCriacao(), emprestimo.getValorEmprestimo(),
        emprestimo.getNumeroParcela(), emprestimo.getStatusPagamento(), pessoaDto);
  }

  public static EmprestimoDto toEmprestimoDto(Emprestimo emprestimo) {
    return new EmprestimoDto(emprestimo.getId(), emprestimo.getDataCriacao(), emprestimo.getValorEmprestimo(),
        emprestimo.getNumeroParcela(), emprestimo.getStatusPagamento(), PessoaMapper.toPessoaDto(emprestimo.getPessoa()));
  }

}
