package br.com.flaviohenrique.cadastroPessoas.dto;

import java.time.OffsetDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.validation.Valid;
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
public class PessoaInputDto{

	@NotBlank(message = "O nome é obrigatório")
	private String nome;
	
	@NotBlank
	@CPF(message = "CPF não é válido")
	private String cpf;
	
	@NotNull
	@Past(message = "Data de nascimento está errada!")
	private OffsetDateTime data_nascimento;

	@OneToMany(targetEntity=ContatoInputDto.class,cascade = {CascadeType.ALL})
	@NotEmpty(message = "Deve ser informando pelo menos um contato")
	private List<@Valid ContatoInputDto> contatos;
}
