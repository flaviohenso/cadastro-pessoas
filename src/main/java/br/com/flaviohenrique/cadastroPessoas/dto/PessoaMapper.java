package br.com.flaviohenrique.cadastroPessoas.dto;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import br.com.flaviohenrique.cadastroPessoas.domain.Contato;
import br.com.flaviohenrique.cadastroPessoas.domain.Pessoa;

@Mapper(componentModel = "spring")
public interface PessoaMapper {	
	
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updatePessoaFromPessoaUpdateDto(PessoaUpdateDto pessoaUpdateDto, @MappingTarget Pessoa entity);
	
}