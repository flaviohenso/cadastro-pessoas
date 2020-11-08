package br.com.flaviohenrique.cadastroPessoas.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class PessoaFilterDto extends PessoaDto{

	private String nome;
	private String cpf;
	private String data_nascimento;
	private Integer pagina;
	private Integer tamanhoPagina;
	
}
