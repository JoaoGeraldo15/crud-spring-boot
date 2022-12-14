package crud.api.springstudy.service.impl;

import crud.api.springstudy.domain.Pessoa;
import crud.api.springstudy.domain.dto.ContatoDTO;
import crud.api.springstudy.domain.dto.PessoaDTO;
import crud.api.springstudy.domain.mapper.PessoaMapper;
import crud.api.springstudy.repository.PessoaRepository;
import crud.api.springstudy.service.PessoaService;
import crud.api.springstudy.service.exceptions.BirthDateViolationException;
import crud.api.springstudy.service.exceptions.EmailNotValid;
import crud.api.springstudy.service.exceptions.MinimumNumberOfContactsException;
import crud.api.springstudy.service.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PessoaServiceImpl implements PessoaService {

    private final PessoaRepository pessoaRepository;

    private final PessoaMapper pessoaMapper;

    private final EmailValidator emailValidator;

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
        // TODO Inserir validações EMAIL
        validarDadosPessoa(pessoaDTO);
        return this.pessoaRepository.save(this.pessoaMapper.toEntity(pessoaDTO));
    }

    private void validarDadosPessoa(PessoaDTO pessoaDTO) {
        validarDataNascimento(pessoaDTO.getDataNascimento());
        validarQuantidadeContatos(pessoaDTO.getContatos());
        validarEmail(pessoaDTO.getContatos());
    }

    private void validarEmail(List<ContatoDTO> contatos) {
        contatos.forEach(contatoDTO -> {
            if (!emailValidator.isValid(contatoDTO.getEmail())) {
                throw new EmailNotValid("Email não válido: " + contatoDTO.getEmail());
            }
        });
    }

    private void validarDataNascimento(LocalDate dataNascimento) {
        if (dataNascimento.isAfter(LocalDate.now())) {
            throw new BirthDateViolationException("A Data de nascimento não pode ser uma data futura.");
        }
    }

    private void validarQuantidadeContatos(List<ContatoDTO> contatos) {
        if (contatos.size() == 0) {
            throw new MinimumNumberOfContactsException("A pessoa deve possuir no mínimo 1 contato para ser cadastrada.");
        }
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
