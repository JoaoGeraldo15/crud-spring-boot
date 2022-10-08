package crud.api.springstudy.service.impl;

import crud.api.springstudy.domain.Pessoa;
import crud.api.springstudy.domain.dto.PessoaDTO;
import crud.api.springstudy.domain.mapper.PessoaMapper;
import crud.api.springstudy.repository.PessoaRepository;
import crud.api.springstudy.service.PessoaService;
import crud.api.springstudy.service.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PessoaServiceImpl implements PessoaService {

    private final PessoaRepository pessoaRepository;

    private final PessoaMapper pessoaMapper;

    @Override
    public Pessoa findById(Long id) {
        Optional<Pessoa> user = this.pessoaRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Pessoa não encontrada"));
    }

    @Override
    public Page<PessoaDTO> findAll(Pageable pageable) {
        return this.pessoaRepository.findAll(pageable).map(pessoaMapper::toDTO);
    }

    @Override
    public Pessoa create(PessoaDTO pessoaDTO) {
        // TODO Inserir validações CPF, EMAIL
        return this.pessoaRepository.save(this.pessoaMapper.toEntity(pessoaDTO));
    }

    @Override
    public Pessoa update(PessoaDTO pessoaDTO) {
        return this.pessoaRepository.save(this.pessoaMapper.toEntity(pessoaDTO));
    }

    @Override
    public void delete(Long id) {
        findById(id);
        this.pessoaRepository.deleteById(id);
    }

}
