package br.com.flaviohenrique.cadastroPessoas.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.flaviohenrique.cadastroPessoas.domain.Pessoa;
import br.com.flaviohenrique.cadastroPessoas.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

	@Autowired
	PessoaService pessoaService;
	
	@Autowired
	private ModelMapper modelMapper;

	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Pessoa cadastrar(@RequestBody Pessoa pessoa){
		System.out.println(pessoa);
		return pessoaService.salvar(pessoa);
	}
	
//	@GetMapping("{id}")
//	public ResponseEntity<Pessoa> buscarPessoa(@PathVariable Long id){
//		return 
//	}
//	
//	@GetMapping
//	public ResponseEntity<T> buscarPessoas(){
//		return
//	}
//
//	@DeleteMapping
//	public ResponseEntity<T> excluirPessoas(){
//		return
//	}
//
//	@PutMapping
//	public ResponseEntity<T> atualizarPessoas(){
//		return
//	}
	
}
