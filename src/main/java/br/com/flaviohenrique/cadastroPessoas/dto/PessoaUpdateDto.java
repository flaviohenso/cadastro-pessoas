package br.com.flaviohenrique.cadastroPessoas.dto;

import java.time.OffsetDateTime;
import java.util.List;

import lombok.Data;

@Data
public class PessoaUpdateDto {

	private Long id;
	private String nome;
	private String cpf;
	private OffsetDateTime data_nascimento;
	private List<ContatoUpdateDto> contatos;
}
