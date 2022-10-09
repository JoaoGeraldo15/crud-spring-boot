package crud.api.springstudy.repository;

import crud.api.springstudy.domain.Pessoa;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends PagingAndSortingRepository<Pessoa, Long> {
}
