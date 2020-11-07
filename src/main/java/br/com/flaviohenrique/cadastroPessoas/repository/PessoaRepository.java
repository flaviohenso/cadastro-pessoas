package br.com.flaviohenrique.cadastroPessoas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.flaviohenrique.cadastroPessoas.domain.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

	public List<Pessoa> findByNomeContaining(String nome);
	public Pessoa findByCpf(String cpf);

}
