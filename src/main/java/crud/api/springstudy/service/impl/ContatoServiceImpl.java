package crud.api.springstudy.service.impl;

import crud.api.springstudy.domain.Contato;
import crud.api.springstudy.domain.dto.ContatoDTO;
import crud.api.springstudy.domain.mapper.ContatoMapper;
import crud.api.springstudy.repository.ContatoRepository;
import crud.api.springstudy.service.ContatoService;
import crud.api.springstudy.service.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContatoServiceImpl implements ContatoService {

    private final ContatoRepository contatoRepository;

    private final ContatoMapper contatoMapper;

    @Override
    public ContatoDTO findById(Long id) {
        Optional<Contato> contato = this.contatoRepository.findById(id);
        if (contato.isPresent()) {
            return this.contatoMapper.toDTO(contato.get());
        }
        throw new ObjectNotFoundException("Contato não encontrada");
    }

}
