package crud.api.springstudy.service;

import crud.api.springstudy.domain.Pessoa;
import crud.api.springstudy.domain.dto.PessoaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PessoaService {

    Pessoa findById(Long id);

    Page<PessoaDTO> findAll(Pageable pageable);

    Pessoa create(PessoaDTO PessoaDTO);

    Pessoa update(PessoaDTO PessoaDTO);

    void  delete(Long id);
}
