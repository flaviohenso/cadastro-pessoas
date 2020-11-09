package br.com.flaviohenrique.cadastroPessoas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.flaviohenrique.cadastroPessoas.domain.Pessoa;
import br.com.flaviohenrique.cadastroPessoas.dto.SimpleSourceDestinationMapper;
import br.com.flaviohenrique.cadastroPessoas.service.PessoaService;

@SpringBootTest
class BuscarPessoaTest {

	@Autowired
	PessoaService pessoaService;
	
	@Autowired
	private SimpleSourceDestinationMapper mapper;

	@Test
	final void buscarPessoaPorIdExistente() {

		assertNotNull(pessoaService.buscarById(1l));
	}

	@Test
	final void buscarPessoaPorIdNaoExistente() {

		assertEquals(null, pessoaService.buscarById(12514l));
	}

	@Test
	final void buscarPessoaPorNome() {
		
		List<Pessoa> pessoas = new ArrayList<>();
		assertNotNull(pessoaService.buscarByName("henrique"));
		assertEquals(pessoas.size() > 0,pessoaService.buscarByName("henrique").size());
//		assertEquals(null
//				, pessoaService.tudo());
	}

}
