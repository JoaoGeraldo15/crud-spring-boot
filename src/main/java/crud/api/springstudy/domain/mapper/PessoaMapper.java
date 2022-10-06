package crud.api.springstudy.domain.mapper;


import crud.api.springstudy.domain.Pessoa;
import crud.api.springstudy.domain.dto.PessoaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PessoaMapper {

    Pessoa toEntity(PessoaDTO pessoaDTO);
    PessoaDTO toDTO(Pessoa pessoa);

}
