package br.com.flaviohenrique.cadastroPessoas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.flaviohenrique.cadastroPessoas.domain.Pessoa;
import br.com.flaviohenrique.cadastroPessoas.service.PessoaService;


@SpringBootTest
class AtualizarPessoaTest {
	
	@Autowired
	PessoaService pessoaService;


	@Test
	@Transactional
	final void atulizaDadosPessoa() {		
		
		Pessoa pessoa = pessoaService.buscarById(2l);
		pessoa.setNome("Thalyson da Silva");
		
		assertEquals(pessoa,pessoaService.atualizar(pessoa));
	}

}
