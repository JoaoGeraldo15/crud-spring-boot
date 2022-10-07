package crud.api.springstudy.service.impl;

import crud.api.springstudy.domain.Pessoa;
import crud.api.springstudy.repository.PessoaRepository;
import crud.api.springstudy.service.PessoaService;
import crud.api.springstudy.service.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PessoaServiceImpl implements PessoaService {

    private final PessoaRepository pessoaRepository;

    @Override
    public Pessoa findById(Long id) {
        Optional<Pessoa> user = this.pessoaRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Pessoa não encontrada"));
    }



}
