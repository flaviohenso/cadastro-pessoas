package br.com.flaviohenrique.cadastroPessoas.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nome", nullable = false)
	@NotBlank
	private String nome;
	@Column(name = "cpf", nullable = false, unique = true)
	@NotBlank
	@CPF(message = "O CPF não é válido")
	private String cpf;
	@Column(name = "data_nascimento", nullable = false)
	private Date data_nascimento;
	@OneToMany( targetEntity=Contato.class,cascade = {CascadeType.ALL} )
	@NotEmpty
	private List<Contato> contatos; 
}
