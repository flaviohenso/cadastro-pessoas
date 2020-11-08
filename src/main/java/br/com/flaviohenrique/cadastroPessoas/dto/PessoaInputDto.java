package br.com.flaviohenrique.cadastroPessoas.dto;

import java.time.OffsetDateTime;
import java.util.List;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class PessoaInputDto extends PessoaDto{

	@NotBlank(message = "O nome é obrigatório")
	private String nome;
	
	@NotBlank
	@CPF(message = "CPF não é válido")
	private String cpf;
	
	@NotNull
	@Past(message = "Data de nascimento está errada!")
	private OffsetDateTime data_nascimento;
	
	@NotEmpty(message = "Deve ser informando pelo menos um contato")
	@OneToMany
	private List<ContatoInputDto> contatos;
}
