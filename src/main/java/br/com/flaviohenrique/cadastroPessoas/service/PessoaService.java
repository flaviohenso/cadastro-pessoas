package br.com.flaviohenrique.cadastroPessoas.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.flaviohenrique.cadastroPessoas.domain.Pessoa;
import br.com.flaviohenrique.cadastroPessoas.domain.exception.BusinessException;
import br.com.flaviohenrique.cadastroPessoas.domain.exception.EntidadeNaoEncontradaException;
import br.com.flaviohenrique.cadastroPessoas.dto.PessoaMapper;
import br.com.flaviohenrique.cadastroPessoas.dto.PessoaUpdateDto;
import br.com.flaviohenrique.cadastroPessoas.repository.PessoaRepository;
import br.com.flaviohenrique.cadastroPessoas.specification.PessoaSpecification;
import br.com.flaviohenrique.cadastroPessoas.specification.SearchCriteria;
import br.com.flaviohenrique.cadastroPessoas.specification.SearchOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PessoaService {

	@Autowired
	PessoaRepository pessoaRespository;

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private PessoaMapper pessoaMapper;

	/*
	 * verificar se já existe um registro no banco para o cpf, caso nao exista
	 * persister no banco
	 */
	public Pessoa salvar(Pessoa pessoa) {

		if(!pessoa.validaContato()) {
			throw new BusinessException("Dados dos contatos estão incorreto!");
		}
		Pessoa pessoaExiste = pessoaRespository.findByCpf(pessoa.getCpf());
		if (pessoaExiste != null) {
			throw new BusinessException("CPF já cadastrado!");
		}
		return pessoaRespository.save(pessoa);
	}

	/*
	 * Se a busca pelo id retorna uma instancia do objeto pessoa, esse mesmo é
	 * retornado
	 */
	public Pessoa buscarById(Long id) {

		Optional<Pessoa> pessoa = pessoaRespository.findById(id);
		if (pessoa.isPresent()) {
			return pessoa.get();
		}
		return null;
	}

	/*
	 * 
	 */
	public List<Pessoa> buscarByFilter(Pessoa pessoa, Integer pagina, Integer tamanhoPagina) {

		log.info("Buscar por filtro");
		PessoaSpecification pessoaSpecification = new PessoaSpecification();
		pessoaSpecification.add(new SearchCriteria("nome", pessoa.getNome(), SearchOperation.LIKE));
		Pageable pageable = PageRequest.of(pagina, tamanhoPagina, Sort.by("nome").descending());
		Page<Pessoa> psPessoaList = pessoaRespository.findAll(pessoaSpecification, pageable);

		return psPessoaList.getContent();

	}

	public List<Pessoa> buscarByName(String nome) {
		return pessoaRespository.findByNomeContaining(nome);
	}

	public Boolean deletar(Long id) {
		if (!pessoaRespository.existsById(id)) {
			return false;
		}
		pessoaRespository.deleteById(id);
		return true;
	}

	public Pessoa atualizar(PessoaUpdateDto pessoaUpdateDto) {

		log.info(pessoaUpdateDto.toString());
		Pessoa pessoa = pessoaRespository.findById(pessoaUpdateDto.getId())
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Pessoa não encontrada!"));	
		pessoaMapper.updatePessoaFromPessoaUpdateDto(pessoaUpdateDto, pessoa);
		return pessoaRespository.save(pessoa);
	}

}
