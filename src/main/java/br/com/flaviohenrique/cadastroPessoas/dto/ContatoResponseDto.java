package br.com.flaviohenrique.cadastroPessoas.dto;

import lombok.Data;

@Data
public class ContatoResponseDto {
	
	private Long id;
	private String nome;
	private String telefone;
	private String email;
	
}
