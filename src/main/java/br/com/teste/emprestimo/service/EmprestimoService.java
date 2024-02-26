package br.com.teste.emprestimo.service;

import br.com.teste.emprestimo.entity.Emprestimo;
import br.com.teste.emprestimo.enums.TipoIdentificadorEnum;
import br.com.teste.emprestimo.exception.BusinessException;
import br.com.teste.emprestimo.mapper.EmprestimoMapper;
import br.com.teste.emprestimo.mapper.PessoaMapper;
import br.com.teste.emprestimo.payload.req.NovoEmprestimoDto;
import br.com.teste.emprestimo.payload.res.EmprestimoDto;
import br.com.teste.emprestimo.payload.res.PessoaDto;
import br.com.teste.emprestimo.repository.EmprestimoRepository;
import br.com.teste.emprestimo.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmprestimoService {

  private final EmprestimoRepository emprestimoRepository;
  private final PessoaRepository pessoaRepository;

  public EmprestimoDto cadastrarEmprestimo(NovoEmprestimoDto novoEmprestimoDto) {
    var pessoa = pessoaRepository.findByIdentificador(novoEmprestimoDto.identificador());

    if (pessoa == null)
      throw new BusinessException("Não foi encontrado portador do identificador informado", "identificador");

    var dadosTipoIdentificador = TipoIdentificadorEnum.procurarPorCodigo(pessoa.getTipoIdentificador());

    if (novoEmprestimoDto.valorEmprestimo().compareTo(dadosTipoIdentificador.getVlrMaxEmprestimo()) > 0)
      throw new BusinessException("Valor ultrapassa o limite máximo", "valorEmprestimo");

    if ((novoEmprestimoDto.valorEmprestimo()/ novoEmprestimoDto.numeroParcelas()) < dadosTipoIdentificador.getVlrMinMensal())
      throw new BusinessException("Valor é inferior ao limite mínimo", "mensagem");

    var emprestimo = EmprestimoMapper.toEmprestimo(novoEmprestimoDto, pessoa);
    var bdEmprestimo = emprestimoRepository.save(emprestimo);
    var pessoaDto = PessoaMapper.toPessoaDto(pessoa);

    return EmprestimoMapper.toEmprestimoDto(bdEmprestimo, pessoaDto);
  }

  public List<EmprestimoDto> buscarEmprestimos() {
    return emprestimoRepository.findAll().stream().map(EmprestimoMapper::toEmprestimoDto).collect(Collectors.toList());
  }

}
