package crud.api.springstudy.service;

import crud.api.springstudy.domain.Contato;
import crud.api.springstudy.domain.dto.ContatoDTO;

public interface ContatoService {

    ContatoDTO findById(Long id);
}
