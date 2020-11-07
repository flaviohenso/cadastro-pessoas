package br.com.flaviohenrique.cadastroPessoas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.flaviohenrique.cadastroPessoas.domain.Pessoa;
import br.com.flaviohenrique.cadastroPessoas.service.PessoaService;

@SpringBootTest
class BuscarPessoaTest {

	@Autowired
	PessoaService pessoaService;
	
	@Test
	final void buscarPessoaPorIdExistente() {		
		Long data = new java.util.Date().getTime();
		
		assertEquals(6l
				, pessoaService.buscarById(6l).getId());
	}
	
	@Test
	final void buscarPessoaPorIdNaoExistente() {		
		Long data = new java.util.Date().getTime();
		
		assertEquals(null
				, pessoaService.buscarById(12514l));
	}
	
	@Test
	final void buscarPessoaPorNome() {		
		Long data = new java.util.Date().getTime();
		
		assertEquals(6l, pessoaService.buscarByName("henrique").get(0).getId());
//		assertEquals(null
//				, pessoaService.tudo());
	}

}
