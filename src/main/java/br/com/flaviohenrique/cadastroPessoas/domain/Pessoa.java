package br.com.flaviohenrique.cadastroPessoas.domain;

import java.time.OffsetDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome", nullable = false)
	@NotBlank(message = "O nome é obrigatório")
	private String nome;

	@Column(name = "cpf", nullable = false, unique = true)
	@NotBlank
	@CPF(message = "CPF não é válido")
	private String cpf;

	@Column(name = "data_nascimento", nullable = false)
	@NotNull
	@Past(message = "Data de nascimento está errada!")
	private OffsetDateTime data_nascimento;

	@OneToMany(targetEntity = Contato.class, fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
	@NotEmpty(message = "Deve ser informando pelo menos um contato")
	private List<@Valid Contato> contatos;

	public Boolean validaContato() {
		if (contatos.size() > 0) {
			for (int i = 0; i < contatos.size(); i++) {
				Contato contato = contatos.get(i);
				if (contato == null) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

}
