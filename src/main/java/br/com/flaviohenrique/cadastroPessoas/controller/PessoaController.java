package br.com.flaviohenrique.cadastroPessoas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.flaviohenrique.cadastroPessoas.domain.Pessoa;
import br.com.flaviohenrique.cadastroPessoas.dto.PessoaFilterDto;
import br.com.flaviohenrique.cadastroPessoas.dto.PessoaInputDto;
import br.com.flaviohenrique.cadastroPessoas.dto.PessoaResponseDto;
import br.com.flaviohenrique.cadastroPessoas.dto.PessoaUpdateDto;
import br.com.flaviohenrique.cadastroPessoas.dto.SimpleSourceDestinationMapper;
import br.com.flaviohenrique.cadastroPessoas.service.PessoaService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/pessoas")
public class PessoaController {

	@Autowired
	PessoaService pessoaService;
		
	@Autowired
	private SimpleSourceDestinationMapper mapper;
	
	/*
	 * Endpoint: recebe o DTO de pessoa, faz o mapeamento do dto para a entity, manda salvar a entity da base de dados,
	 * mapea o retorno para um DTO.
	 */
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public PessoaResponseDto cadastrar(@RequestBody @Valid PessoaInputDto pessoaInputDto){
		log.info("chamada ao Endpoint cadastrar pessoa");
		
		Pessoa pessoa = mapper.pessoaInputDtoToPessoa(pessoaInputDto);
		PessoaResponseDto pessoaResponseDto = mapper.pessoaToPessoaResponseDto(pessoaService.salvar(pessoa));
		return pessoaResponseDto;
	}
	
	/*
	 * Endpoint: receber o id pela url da requisicao, busca na base de dados o id, mapea o retorno da busca para um
	 * DTO, verifica se DTO esta nulo e retorna um ResponseEntity.
	 */
	@GetMapping("{id}")
	public ResponseEntity<PessoaResponseDto> buscar(@PathVariable Long id){
		log.info("chamada ao Endpoint buscar pessoa por ID");
		
		Pessoa pessoa = pessoaService.buscarById(id);
		PessoaResponseDto pessoaResponseDto = mapper.pessoaToPessoaResponseDto(pessoa);
		return  pessoaResponseDto != null ? ResponseEntity.ok(pessoaResponseDto) : ResponseEntity.notFound().build();
	}
	
	/*
	 * Endpoint
	 */
	@PostMapping("buscar")
	public ResponseEntity<List<PessoaResponseDto>> buscarPessoas(@RequestBody PessoaFilterDto pessoaFilterDto){
		log.info("chamada ao Endpoint buscarPessoas");
		
		Pessoa pessoa = mapper.pessoaFilterDtoDtoToPessoa(pessoaFilterDto);
		List<Pessoa> pessoas =  pessoaService.buscarByFilter(pessoa,pessoaFilterDto.getPagina(),pessoaFilterDto.getTamanhoPagina());
		List<PessoaResponseDto> pessoaResponseDtos = mapper.pessoasToPessoaResponseDtos(pessoas);
		return pessoaResponseDtos != null ? ResponseEntity.ok(pessoaResponseDtos): ResponseEntity.notFound().build();
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id){
		log.info("chamada ao Endpoint excluir pessoa");
		
		return pessoaService.deletar(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
	}

	@PutMapping
	public PessoaResponseDto atualizar(@RequestBody PessoaUpdateDto pessoaUpdateDto){
		log.info("chamada ao Endpoint Atualizar pessoa");
		
		PessoaResponseDto pessoaResponseDto = mapper.pessoaToPessoaResponseDto(pessoaService.atualizar(pessoaUpdateDto));
		return pessoaResponseDto;
	}
		
}
