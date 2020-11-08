package br.com.flaviohenrique.cadastroPessoas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@NotBlank(message = "O nome do contato é obrigatório")
	private String nome;
	
	@Column
	@NotBlank(message = "Telefone do contato é obrigatório")
	private String telefone;
	
	@Column
	@NotBlank(message = "O email do contato é obrigatório")
	@Email(message = "Deve ser informando um email válido")
	private String email;
	
	
	
}
