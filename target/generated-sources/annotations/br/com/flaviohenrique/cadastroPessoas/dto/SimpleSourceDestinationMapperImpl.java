package br.com.flaviohenrique.cadastroPessoas.dto;

import br.com.flaviohenrique.cadastroPessoas.domain.Contato;
import br.com.flaviohenrique.cadastroPessoas.domain.Pessoa;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-11-08T23:26:50-0300",
    comments = "version: 1.4.1.Final, compiler: Eclipse JDT (IDE) 1.3.1100.v20200828-0941, environment: Java 14.0.2 (Oracle Corporation)"
)
@Component
public class SimpleSourceDestinationMapperImpl implements SimpleSourceDestinationMapper {

    @Override
    public Pessoa pessoaUpdateDtoToPessoa(PessoaUpdateDto pessoaUpdateDto) {
        if ( pessoaUpdateDto == null ) {
            return null;
        }

        Pessoa pessoa = new Pessoa();

        pessoa.setContatos( contatoUpdateDtoListToContatoList( pessoaUpdateDto.getContatos() ) );
        pessoa.setCpf( pessoaUpdateDto.getCpf() );
        pessoa.setData_nascimento( pessoaUpdateDto.getData_nascimento() );
        pessoa.setId( pessoaUpdateDto.getId() );
        pessoa.setNome( pessoaUpdateDto.getNome() );

        return pessoa;
    }

    @Override
    public PessoaUpdateDto pessoaToPessoaUpdateDto(Pessoa pessoa) {
        if ( pessoa == null ) {
            return null;
        }

        PessoaUpdateDto pessoaUpdateDto = new PessoaUpdateDto();

        pessoaUpdateDto.setContatos( contatoListToContatoUpdateDtoList( pessoa.getContatos() ) );
        pessoaUpdateDto.setCpf( pessoa.getCpf() );
        pessoaUpdateDto.setData_nascimento( pessoa.getData_nascimento() );
        pessoaUpdateDto.setId( pessoa.getId() );
        pessoaUpdateDto.setNome( pessoa.getNome() );

        return pessoaUpdateDto;
    }

    @Override
    public Pessoa pessoaInputDtoToPessoa(PessoaInputDto pessoaInputDto) {
        if ( pessoaInputDto == null ) {
            return null;
        }

        Pessoa pessoa = new Pessoa();

        pessoa.setContatos( contatoInputDtoListToContatoList( pessoaInputDto.getContatos() ) );
        pessoa.setCpf( pessoaInputDto.getCpf() );
        pessoa.setData_nascimento( pessoaInputDto.getData_nascimento() );
        pessoa.setNome( pessoaInputDto.getNome() );

        return pessoa;
    }

    @Override
    public PessoaInputDto pessoaToPessoaInputDto(Pessoa pessoa) {
        if ( pessoa == null ) {
            return null;
        }

        PessoaInputDto pessoaInputDto = new PessoaInputDto();

        pessoaInputDto.setContatos( contatoListToContatoInputDtoList( pessoa.getContatos() ) );
        pessoaInputDto.setCpf( pessoa.getCpf() );
        pessoaInputDto.setData_nascimento( pessoa.getData_nascimento() );
        pessoaInputDto.setNome( pessoa.getNome() );

        return pessoaInputDto;
    }

    @Override
    public Pessoa pessoaResponseDtoToPessoa(PessoaResponseDto pessoaResponseDto) {
        if ( pessoaResponseDto == null ) {
            return null;
        }

        Pessoa pessoa = new Pessoa();

        pessoa.setContatos( contatoResponseDtoListToContatoList( pessoaResponseDto.getContatos() ) );
        pessoa.setCpf( pessoaResponseDto.getCpf() );
        pessoa.setData_nascimento( pessoaResponseDto.getData_nascimento() );
        pessoa.setId( pessoaResponseDto.getId() );
        pessoa.setNome( pessoaResponseDto.getNome() );

        return pessoa;
    }

    @Override
    public PessoaResponseDto pessoaToPessoaResponseDto(Pessoa pessoa) {
        if ( pessoa == null ) {
            return null;
        }

        PessoaResponseDto pessoaResponseDto = new PessoaResponseDto();

        pessoaResponseDto.setContatos( contatoListToContatoResponseDtoList( pessoa.getContatos() ) );
        pessoaResponseDto.setCpf( pessoa.getCpf() );
        pessoaResponseDto.setData_nascimento( pessoa.getData_nascimento() );
        pessoaResponseDto.setId( pessoa.getId() );
        pessoaResponseDto.setNome( pessoa.getNome() );

        return pessoaResponseDto;
    }

    @Override
    public Pessoa pessoaFilterDtoDtoToPessoa(PessoaFilterDto pessoaFilterDto) {
        if ( pessoaFilterDto == null ) {
            return null;
        }

        Pessoa pessoa = new Pessoa();

        pessoa.setCpf( pessoaFilterDto.getCpf() );
        pessoa.setData_nascimento( pessoaFilterDto.getData_nascimento() );
        pessoa.setNome( pessoaFilterDto.getNome() );

        return pessoa;
    }

    @Override
    public PessoaFilterDto pessoaTopessoaFilterDto(Pessoa pessoa) {
        if ( pessoa == null ) {
            return null;
        }

        PessoaFilterDto pessoaFilterDto = new PessoaFilterDto();

        pessoaFilterDto.setCpf( pessoa.getCpf() );
        pessoaFilterDto.setData_nascimento( pessoa.getData_nascimento() );
        pessoaFilterDto.setNome( pessoa.getNome() );

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

    protected Contato contatoUpdateDtoToContato(ContatoUpdateDto contatoUpdateDto) {
        if ( contatoUpdateDto == null ) {
            return null;
        }

        Contato contato = new Contato();

        contato.setEmail( contatoUpdateDto.getEmail() );
        contato.setId( contatoUpdateDto.getId() );
        contato.setNome( contatoUpdateDto.getNome() );
        contato.setTelefone( contatoUpdateDto.getTelefone() );

        return contato;
    }

    protected List<Contato> contatoUpdateDtoListToContatoList(List<ContatoUpdateDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Contato> list1 = new ArrayList<Contato>( list.size() );
        for ( ContatoUpdateDto contatoUpdateDto : list ) {
            list1.add( contatoUpdateDtoToContato( contatoUpdateDto ) );
        }

        return list1;
    }

    protected ContatoUpdateDto contatoToContatoUpdateDto(Contato contato) {
        if ( contato == null ) {
            return null;
        }

        ContatoUpdateDto contatoUpdateDto = new ContatoUpdateDto();

        contatoUpdateDto.setEmail( contato.getEmail() );
        contatoUpdateDto.setId( contato.getId() );
        contatoUpdateDto.setNome( contato.getNome() );
        contatoUpdateDto.setTelefone( contato.getTelefone() );

        return contatoUpdateDto;
    }

    protected List<ContatoUpdateDto> contatoListToContatoUpdateDtoList(List<Contato> list) {
        if ( list == null ) {
            return null;
        }

        List<ContatoUpdateDto> list1 = new ArrayList<ContatoUpdateDto>( list.size() );
        for ( Contato contato : list ) {
            list1.add( contatoToContatoUpdateDto( contato ) );
        }

        return list1;
    }

    protected Contato contatoInputDtoToContato(ContatoInputDto contatoInputDto) {
        if ( contatoInputDto == null ) {
            return null;
        }

        Contato contato = new Contato();

        contato.setEmail( contatoInputDto.getEmail() );
        contato.setNome( contatoInputDto.getNome() );
        contato.setTelefone( contatoInputDto.getTelefone() );

        return contato;
    }

    protected List<Contato> contatoInputDtoListToContatoList(List<ContatoInputDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Contato> list1 = new ArrayList<Contato>( list.size() );
        for ( ContatoInputDto contatoInputDto : list ) {
            list1.add( contatoInputDtoToContato( contatoInputDto ) );
        }

        return list1;
    }

    protected ContatoInputDto contatoToContatoInputDto(Contato contato) {
        if ( contato == null ) {
            return null;
        }

        ContatoInputDto contatoInputDto = new ContatoInputDto();

        contatoInputDto.setEmail( contato.getEmail() );
        contatoInputDto.setNome( contato.getNome() );
        contatoInputDto.setTelefone( contato.getTelefone() );

        return contatoInputDto;
    }

    protected List<ContatoInputDto> contatoListToContatoInputDtoList(List<Contato> list) {
        if ( list == null ) {
            return null;
        }

        List<ContatoInputDto> list1 = new ArrayList<ContatoInputDto>( list.size() );
        for ( Contato contato : list ) {
            list1.add( contatoToContatoInputDto( contato ) );
        }

        return list1;
    }

    protected Contato contatoResponseDtoToContato(ContatoResponseDto contatoResponseDto) {
        if ( contatoResponseDto == null ) {
            return null;
        }

        Contato contato = new Contato();

        contato.setEmail( contatoResponseDto.getEmail() );
        contato.setId( contatoResponseDto.getId() );
        contato.setNome( contatoResponseDto.getNome() );
        contato.setTelefone( contatoResponseDto.getTelefone() );

        return contato;
    }

    protected List<Contato> contatoResponseDtoListToContatoList(List<ContatoResponseDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Contato> list1 = new ArrayList<Contato>( list.size() );
        for ( ContatoResponseDto contatoResponseDto : list ) {
            list1.add( contatoResponseDtoToContato( contatoResponseDto ) );
        }

        return list1;
    }

    protected ContatoResponseDto contatoToContatoResponseDto(Contato contato) {
        if ( contato == null ) {
            return null;
        }

        ContatoResponseDto contatoResponseDto = new ContatoResponseDto();

        contatoResponseDto.setEmail( contato.getEmail() );
        contatoResponseDto.setId( contato.getId() );
        contatoResponseDto.setNome( contato.getNome() );
        contatoResponseDto.setTelefone( contato.getTelefone() );

        return contatoResponseDto;
    }

    protected List<ContatoResponseDto> contatoListToContatoResponseDtoList(List<Contato> list) {
        if ( list == null ) {
            return null;
        }

        List<ContatoResponseDto> list1 = new ArrayList<ContatoResponseDto>( list.size() );
        for ( Contato contato : list ) {
            list1.add( contatoToContatoResponseDto( contato ) );
        }

        return list1;
    }
}
