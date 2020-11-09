package br.com.flaviohenrique.cadastroPessoas;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.flaviohenrique.cadastroPessoas.domain.Pessoa;
import br.com.flaviohenrique.cadastroPessoas.dto.PessoaUpdateDto;
import br.com.flaviohenrique.cadastroPessoas.dto.SimpleSourceDestinationMapper;
import br.com.flaviohenrique.cadastroPessoas.service.PessoaService;


@SpringBootTest
class AtualizarPessoaTest {
	
	@Autowired
	PessoaService pessoaService;

	@Autowired
	private SimpleSourceDestinationMapper mapper;

	@Test
	@Transactional
	final void atulizaDadosPessoa() {		
		
		PessoaUpdateDto pessoaUpdateDto = new PessoaUpdateDto();
		pessoaUpdateDto.setId(1l);
		pessoaUpdateDto.setNome("Andreia Michelle G. Nascimento");
		
		Pessoa pessoa = pessoaService.buscarById(pessoaUpdateDto.getId());
		
		//Pessoa retorno = pessoaService.atualizar(pessoaUpdateDto);
		
		pessoa.setNome("teste");
		
		assertNotNull(pessoaService.atualizar(pessoaUpdateDto));
	}

}
