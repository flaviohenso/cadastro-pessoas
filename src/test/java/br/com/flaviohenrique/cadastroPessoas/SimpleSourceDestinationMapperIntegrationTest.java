package br.com.flaviohenrique.cadastroPessoas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.flaviohenrique.cadastroPessoas.domain.Pessoa;
import br.com.flaviohenrique.cadastroPessoas.dto.PessoaUpdateDto;
import br.com.flaviohenrique.cadastroPessoas.dto.SimpleSourceDestinationMapper;

@SpringBootTest
class SimpleSourceDestinationMapperIntegrationTest {

	@Autowired
	private SimpleSourceDestinationMapper mapper;

	@Test
	public void verificaMapeamentoPessoaUpdateDtoToPessoaEstaCorreto() {
		PessoaUpdateDto pessoaUpdateDto = new PessoaUpdateDto();
		pessoaUpdateDto.setNome("Joao da silva");
		pessoaUpdateDto.setCpf("429.019.590-32");
		Pessoa pessoa = mapper.pessoaUpdateDtoToPessoa(pessoaUpdateDto);

		assertEquals(pessoaUpdateDto.getNome(), pessoa.getNome());
		assertEquals(pessoaUpdateDto.getCpf(), pessoa.getCpf());
	}

	@Test
	public void verificaMapeamentoPessoaToPessoaUpdateDtoEstaCorreto() {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("joao da silva");
		pessoa.setCpf("429.019.590-32");
		PessoaUpdateDto pessoaUpdateDto = mapper.pessoaToPessoaUpdateDto(pessoa);
		assertEquals(pessoa.getNome(), pessoaUpdateDto.getNome());
		assertEquals(pessoa.getCpf(), pessoaUpdateDto.getCpf());
	}
}
