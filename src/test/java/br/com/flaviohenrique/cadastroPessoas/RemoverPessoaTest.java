package br.com.flaviohenrique.cadastroPessoas;


import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.flaviohenrique.cadastroPessoas.service.PessoaService;

@SpringBootTest
class RemoverPessoaTest {

	@Autowired
	PessoaService pessoaService;
	
	Long data = new java.util.Date().getTime();
	
	@Test
	final void removerPessoaPorId() {
		assertEquals(true
				,pessoaService.deletar(1l));
	}

}
