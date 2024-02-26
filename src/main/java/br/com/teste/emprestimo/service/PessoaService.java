package br.com.teste.emprestimo.service;

import br.com.teste.emprestimo.entity.Pessoa;
import br.com.teste.emprestimo.enums.TipoIdentificadorEnum;
import br.com.teste.emprestimo.exception.BusinessException;
import br.com.teste.emprestimo.exception.RegistroDuplicadoException;
import br.com.teste.emprestimo.payload.req.NovaPessoaDto;
import br.com.teste.emprestimo.payload.res.PessoaDto;
import br.com.teste.emprestimo.payload.res.ValidacaoIdentificadorDto;
import br.com.teste.emprestimo.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@AllArgsConstructor
public class PessoaService {

  private final PessoaRepository pessoaRepository;
  private final RestClient restClient = RestClient.create();

  public PessoaDto cadastrarPessoa(NovaPessoaDto novaPessoaDto) {
    var identificadorNums = novaPessoaDto.identificador().replaceAll("[^0-9]", "");
    var tipoIdentificadorEnum = TipoIdentificadorEnum.procurarPorTamanho(identificadorNums.length());

    if (tipoIdentificadorEnum == null) {
      throw new BusinessException("O tamanho do identificador somente com os números deve ser 11, 14, 8 ou 10", "identificador");
    }

    if (!validarIdentificador(identificadorNums, tipoIdentificadorEnum.getCodigo())) {
      throw new BusinessException("Identificador do tipo " + tipoIdentificadorEnum.getCodigo() + " inválido", "identificador");
    }

    if (pessoaRepository.findByIdentificador(identificadorNums) != null) {
      throw new RegistroDuplicadoException("Já possui uma pessoa com este identificador");
    }

    var pessoa = new Pessoa();
    pessoa.setNome(novaPessoaDto.nome());
    pessoa.setDataNascimento(novaPessoaDto.dataNascimento());
    pessoa.setIdentificador(identificadorNums);
    pessoa.setTipoIdentificador(tipoIdentificadorEnum.getCodigo());
    pessoa.setValorMinMensal(tipoIdentificadorEnum.getVlrMinMensal());
    pessoa.setValorMaxEmprestimo(tipoIdentificadorEnum.getVlrMaxEmprestimo());

    var novaPessoa = pessoaRepository.save(pessoa);

    return new PessoaDto(novaPessoa.getId(), novaPessoa.getNome(), novaPessoa.getDataNascimento(), novaPessoa.getIdentificador(), novaPessoa.getTipoIdentificador(), novaPessoa.getValorMinMensal(), novaPessoa.getValorMaxEmprestimo());
  }

  public boolean validarIdentificador(String identificador, String tipoIdentificador) {
    if (tipoIdentificador.equals(TipoIdentificadorEnum.PF.getCodigo())) {
      return restClient
          .get()
          .uri("https://api-validador-cpf.vercel.app/validarcpf/" + identificador)
          .retrieve()
          .body(ValidacaoIdentificadorDto.class)
          .valid();
    } else if (tipoIdentificador.equals(TipoIdentificadorEnum.PJ.getCodigo())) {
      return restClient
          .get()
          .uri("https://api-validador-cpf.vercel.app/validarcnpj/" + identificador)
          .retrieve()
          .body(ValidacaoIdentificadorDto.class)
          .valid();
    } else if (tipoIdentificador.equals(TipoIdentificadorEnum.EU.getCodigo())) {
      return (int) identificador.charAt(0) + (int) identificador.charAt(7) == 9;
    } else if (tipoIdentificador.equals(TipoIdentificadorEnum.AP.getCodigo())) {
      return identificador.substring(0, 9).contains(identificador.substring(9));
    } else {
      return false;
    }
  }

}
