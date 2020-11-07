package br.com.flaviohenrique.cadastroPessoas;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.flaviohenrique.cadastroPessoas.domain.Contato;
import br.com.flaviohenrique.cadastroPessoas.domain.Pessoa;
import br.com.flaviohenrique.cadastroPessoas.service.PessoaService;

@SpringBootTest
class CadastrarPessoaTest {
	
	@Autowired
	PessoaService pessoaService;

	@Test
	final void insertPessoaBancoTest() {		
		Long data = new java.util.Date().getTime();		
		
		List<Contato> contatos = new ArrayList<>();
		
		contatos.add(new Contato(null, "Andreia", "998218129", "andreia@gmail.com"));
		contatos.add(new Contato(null, "jardel", "998218130", "jardel@gmail.com"));
		contatos.add(new Contato(null, "fabio", "998218131", "fabio@gmail.com"));
		
		Pessoa pessoa = new Pessoa(null, "Flavio Henrique s. cabral", "05659131409", new Date(data),contatos); 
		assertNotNull(pessoaService.salvar(pessoa).getId());
	}
}
