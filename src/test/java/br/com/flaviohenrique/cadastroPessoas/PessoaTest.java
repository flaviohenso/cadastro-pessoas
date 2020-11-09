package br.com.flaviohenrique.cadastroPessoas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.flaviohenrique.cadastroPessoas.domain.Pessoa;
import br.com.flaviohenrique.cadastroPessoas.dto.ContatoInputDto;
import br.com.flaviohenrique.cadastroPessoas.dto.PessoaInputDto;
import br.com.flaviohenrique.cadastroPessoas.dto.SimpleSourceDestinationMapper;
import br.com.flaviohenrique.cadastroPessoas.service.PessoaService;

@SpringBootTest
class PessoaTest {

	@Autowired
	PessoaService pessoaService;
	
	@Autowired
	private SimpleSourceDestinationMapper mapper;
	
	@Test
    public void testValidaCamposObrigatorio() {
        try {
        	List<ContatoInputDto> contatoInputDtos = new ArrayList<>();
    		
    		contatoInputDtos.add(new ContatoInputDto("Andreia", "998218129", "andreia@gmail.com"));
    		contatoInputDtos.add(new ContatoInputDto("jardel", "998218130", "jardel@gmail.com"));
    		contatoInputDtos.add(new ContatoInputDto("fabio", "998218131", "fabio@gmail.com"));
    		
    		PessoaInputDto pessoaInputDto = new PessoaInputDto("", "05659131409", OffsetDateTime.now(),contatoInputDtos); 
    		Pessoa pessoa = mapper.pessoaInputDtoToPessoa(pessoaInputDto);
    		fail("O nome é obrigatório");
        } catch (IllegalArgumentException e) {
            assertEquals("O nome é obrigatório", e.getMessage());
        }
    }
	
}
