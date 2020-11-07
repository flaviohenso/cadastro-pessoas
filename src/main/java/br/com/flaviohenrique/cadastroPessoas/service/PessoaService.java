package br.com.flaviohenrique.cadastroPessoas.service;



import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.flaviohenrique.cadastroPessoas.domain.Pessoa;
import br.com.flaviohenrique.cadastroPessoas.domain.exception.BusinessException;
import br.com.flaviohenrique.cadastroPessoas.repository.PessoaRepository;

@Service
@Transactional
public class PessoaService {
	
	@Autowired
	PessoaRepository pessoaRespository;
	
	@PersistenceContext
	private EntityManager entityManager;

	public Pessoa salvar(Pessoa pessoa) {
		
		Pessoa pessoaExiste = pessoaRespository.findByCpf(pessoa.getCpf());
		
		if(pessoaExiste != null) {
			throw new BusinessException("CPF já cadastrado!");
		}
				
		return pessoaRespository.save(pessoa);
	}
	
	public Pessoa buscarById(Long id) {	
		
		Optional<Pessoa> pessoa = pessoaRespository.findById(id);
		
		if (pessoa.isPresent()) {
			return pessoa.get();
		}
		
		return null;
	}
	
	public List<Pessoa> buscarByName(String nome) {		
		return pessoaRespository.findByNomeContaining(nome);
	}

	public List<Pessoa> tudo(){
		return pessoaRespository.findAll();
	}
	
	public Boolean deletar(Long id) {		
		if(!pessoaRespository.existsById(id)) {
			return false;
		}
		pessoaRespository.deleteById(id);
		return true;
	}
	
	public Pessoa atualizar(Pessoa pessoa) {
		if(!pessoaRespository.existsById(pessoa.getId())) {
			return null;
		}
		
		pessoaRespository.save(pessoa);
		return pessoa;
	}

	
}
