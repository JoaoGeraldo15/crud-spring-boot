package crud.api.springstudy.resource;

import crud.api.springstudy.domain.dto.PessoaDTO;
import crud.api.springstudy.domain.mapper.PessoaMapper;
import crud.api.springstudy.service.PessoaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "pessoa")
@AllArgsConstructor
public class PessoaResource {

    public static final String ID = "/{id}";
    private PessoaService pessoaService;

    private PessoaMapper pessoaMapper;

    @GetMapping(value = ID)
    public ResponseEntity<PessoaDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(this.pessoaMapper.toDTO(this.pessoaService.findById(id)));
    }

}
