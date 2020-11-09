package br.com.flaviohenrique.cadastroPessoas.dto;

import br.com.flaviohenrique.cadastroPessoas.domain.Contato;
import br.com.flaviohenrique.cadastroPessoas.domain.Pessoa;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-11-08T23:03:04-0300",
    comments = "version: 1.4.1.Final, compiler: Eclipse JDT (IDE) 1.3.1100.v20200828-0941, environment: Java 14.0.2 (Oracle Corporation)"
)
@Component
public class PessoaMapperImpl implements PessoaMapper {

    @Override
    public void updatePessoaFromPessoaUpdateDto(PessoaUpdateDto pessoaUpdateDto, Pessoa entity) {
        if ( pessoaUpdateDto == null ) {
            return;
        }

        if ( entity.getContatos() != null ) {
            List<Contato> list = contatoUpdateDtoListToContatoList( pessoaUpdateDto.getContatos() );
            if ( list != null ) {
                entity.getContatos().clear();
                entity.getContatos().addAll( list );
            }
        }
        else {
            List<Contato> list = contatoUpdateDtoListToContatoList( pessoaUpdateDto.getContatos() );
            if ( list != null ) {
                entity.setContatos( list );
            }
        }
        if ( pessoaUpdateDto.getCpf() != null ) {
            entity.setCpf( pessoaUpdateDto.getCpf() );
        }
        if ( pessoaUpdateDto.getData_nascimento() != null ) {
            entity.setData_nascimento( pessoaUpdateDto.getData_nascimento() );
        }
        if ( pessoaUpdateDto.getId() != null ) {
            entity.setId( pessoaUpdateDto.getId() );
        }
        if ( pessoaUpdateDto.getNome() != null ) {
            entity.setNome( pessoaUpdateDto.getNome() );
        }
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
}
