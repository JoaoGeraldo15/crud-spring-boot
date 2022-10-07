package crud.api.springstudy.service;

import crud.api.springstudy.domain.Pessoa;
import crud.api.springstudy.domain.dto.PessoaDTO;

public interface PessoaService {

    Pessoa findById(Long id);

    Pessoa create(PessoaDTO PessoaDTO);

    Pessoa update(PessoaDTO PessoaDTO);

    void  delete(Long id);
}
