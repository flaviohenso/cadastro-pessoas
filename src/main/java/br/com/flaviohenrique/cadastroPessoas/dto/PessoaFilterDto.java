package br.com.flaviohenrique.cadastroPessoas.dto;

import java.time.OffsetDateTime;

import lombok.Data;

@Data
public class PessoaFilterDto{

	private String nome;
	private String cpf;
	private OffsetDateTime data_nascimento;
	private Integer pagina;
	private Integer tamanhoPagina;
	
}
