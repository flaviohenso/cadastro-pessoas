package br.com.flaviohenrique.cadastroPessoas.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContatoInputDto {

	@NotBlank(message = "O nome do contato é obrigatório")
	private String nome;
	
	@NotBlank(message = "Telefone do contato é obrigatório")
	private String telefone;
	
	@NotBlank(message = "O email do contato é obrigatório")
	@Email(message = "Deve ser informando um email válido")
	private String email;
	
}
