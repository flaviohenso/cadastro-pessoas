package br.com.flaviohenrique.cadastroPessoas.dto;

import br.com.flaviohenrique.cadastroPessoas.domain.Pessoa;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-11-08T23:01:26-0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.8 (Oracle Corporation)"
)
@Component
public class SimpleSourceDestinationMapperImpl implements SimpleSourceDestinationMapper {

    @Override
    public Pessoa pessoaUpdateDtoToPessoa(PessoaUpdateDto pessoaUpdateDto) {
        if ( pessoaUpdateDto == null ) {
            return null;
        }

        Pessoa pessoa = new Pessoa();

        return pessoa;
    }

    @Override
    public PessoaUpdateDto pessoaToPessoaUpdateDto(Pessoa pessoa) {
        if ( pessoa == null ) {
            return null;
        }

        PessoaUpdateDto pessoaUpdateDto = new PessoaUpdateDto();

        return pessoaUpdateDto;
    }

    @Override
    public Pessoa pessoaInputDtoToPessoa(PessoaInputDto pessoaInputDto) {
        if ( pessoaInputDto == null ) {
            return null;
        }

        Pessoa pessoa = new Pessoa();

        return pessoa;
    }

    @Override
    public PessoaInputDto pessoaToPessoaInputDto(Pessoa pessoa) {
        if ( pessoa == null ) {
            return null;
        }

        PessoaInputDto pessoaInputDto = new PessoaInputDto();

        return pessoaInputDto;
    }

    @Override
    public Pessoa pessoaResponseDtoToPessoa(PessoaResponseDto pessoaResponseDto) {
        if ( pessoaResponseDto == null ) {
            return null;
        }

        Pessoa pessoa = new Pessoa();

        return pessoa;
    }

    @Override
    public PessoaResponseDto pessoaToPessoaResponseDto(Pessoa pessoa) {
        if ( pessoa == null ) {
            return null;
        }

        PessoaResponseDto pessoaResponseDto = new PessoaResponseDto();

        return pessoaResponseDto;
    }

    @Override
    public Pessoa pessoaFilterDtoDtoToPessoa(PessoaFilterDto pessoaFilterDto) {
        if ( pessoaFilterDto == null ) {
            return null;
        }

        Pessoa pessoa = new Pessoa();

        return pessoa;
    }

    @Override
    public PessoaFilterDto pessoaTopessoaFilterDto(Pessoa pessoa) {
        if ( pessoa == null ) {
            return null;
        }

        PessoaFilterDto pessoaFilterDto = new PessoaFilterDto();

        return pessoaFilterDto;
    }

    @Override
    public List<Pessoa> PessoaResponseDtosToPessoas(List<PessoaResponseDto> pessoaResponseDtos) {
        if ( pessoaResponseDtos == null ) {
            return null;
        }

        List<Pessoa> list = new ArrayList<Pessoa>( pessoaResponseDtos.size() );
        for ( PessoaResponseDto pessoaResponseDto : pessoaResponseDtos ) {
            list.add( pessoaResponseDtoToPessoa( pessoaResponseDto ) );
        }

        return list;
    }

    @Override
    public List<PessoaResponseDto> pessoasToPessoaResponseDtos(List<Pessoa> pessoas) {
        if ( pessoas == null ) {
            return null;
        }

        List<PessoaResponseDto> list = new ArrayList<PessoaResponseDto>( pessoas.size() );
        for ( Pessoa pessoa : pessoas ) {
            list.add( pessoaToPessoaResponseDto( pessoa ) );
        }

        return list;
    }
}
