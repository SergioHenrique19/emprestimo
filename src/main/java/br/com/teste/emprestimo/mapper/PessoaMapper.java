package br.com.teste.emprestimo.mapper;

import br.com.teste.emprestimo.entity.Pessoa;
import br.com.teste.emprestimo.enums.TipoIdentificadorEnum;
import br.com.teste.emprestimo.payload.req.NovaPessoaDto;
import br.com.teste.emprestimo.payload.res.PessoaDto;

public class PessoaMapper {

  public static Pessoa toPessoa(NovaPessoaDto novaPessoaDto, String idNums, TipoIdentificadorEnum tpe) {
    var pessoa = new Pessoa();
    pessoa.setNome(novaPessoaDto.nome());
    pessoa.setDataNascimento(novaPessoaDto.dataNascimento());
    pessoa.setIdentificador(idNums);
    pessoa.setTipoIdentificador(tpe.getCodigo());
    pessoa.setValorMinMensal(tpe.getVlrMinMensal());
    pessoa.setValorMaxEmprestimo(tpe.getVlrMaxEmprestimo());

    return pessoa;
  }

  public static PessoaDto toPessoaDto(Pessoa pessoa) {
    return new PessoaDto(pessoa.getId(), pessoa.getNome(), pessoa.getDataNascimento(), pessoa.getIdentificador(),
        pessoa.getTipoIdentificador(), pessoa.getValorMinMensal(), pessoa.getValorMaxEmprestimo());
  }

}
