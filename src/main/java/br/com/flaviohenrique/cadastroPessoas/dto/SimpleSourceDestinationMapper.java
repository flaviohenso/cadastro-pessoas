package br.com.flaviohenrique.cadastroPessoas.dto;

import java.util.List;

import org.mapstruct.Mapper;

import br.com.flaviohenrique.cadastroPessoas.domain.Pessoa;

@Mapper(componentModel = "spring")
public interface SimpleSourceDestinationMapper {
	Pessoa pessoaUpdateDtoToPessoa(PessoaUpdateDto pessoaUpdateDto);
    PessoaUpdateDto pessoaToPessoaUpdateDto(Pessoa pessoa);
    
	Pessoa pessoaInputDtoToPessoa(PessoaInputDto pessoaInputDto);
    PessoaInputDto pessoaToPessoaInputDto(Pessoa pessoa);
    
    Pessoa pessoaResponseDtoToPessoa(PessoaResponseDto pessoaResponseDto);
    PessoaResponseDto pessoaToPessoaResponseDto(Pessoa pessoa);
    
    Pessoa pessoaFilterDtoDtoToPessoa(PessoaFilterDto pessoaFilterDto);
    PessoaFilterDto pessoaTopessoaFilterDto(Pessoa pessoa);

    List<Pessoa> PessoaResponseDtosToPessoas(List<PessoaResponseDto> pessoaResponseDtos);
    List<PessoaResponseDto> pessoasToPessoaResponseDtos(List<Pessoa> pessoas);
}
