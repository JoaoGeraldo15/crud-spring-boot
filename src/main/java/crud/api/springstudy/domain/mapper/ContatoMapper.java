package crud.api.springstudy.domain.mapper;


import crud.api.springstudy.domain.Contato;
import crud.api.springstudy.domain.dto.ContatoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContatoMapper {

    Contato toEntity(ContatoDTO contatoDTO);
    ContatoDTO toDTO(Contato contato);

}
