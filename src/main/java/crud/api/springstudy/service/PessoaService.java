package crud.api.springstudy.service;

import crud.api.springstudy.domain.Pessoa;

public interface PessoaService {

    Pessoa findById(Long id);

}
