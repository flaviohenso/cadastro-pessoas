package br.com.flaviohenrique.cadastroPessoas.dto;

import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
public class PessoaResponseDto {
	
	private Long id;
	private String nome;
	private String cpf;
	private String data_nascimento;
	
	@OneToMany(fetch = FetchType.EAGER)
	private List<ContatoResponseDto> contatoResponseDtos;
	
}
