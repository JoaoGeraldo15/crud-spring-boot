package crud.api.springstudy.resource;

import crud.api.springstudy.domain.Pessoa;
import crud.api.springstudy.domain.dto.PessoaDTO;
import crud.api.springstudy.domain.mapper.PessoaMapper;
import crud.api.springstudy.service.PessoaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

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

    @PostMapping
    public ResponseEntity<PessoaDTO> create(@RequestBody PessoaDTO pessoaDTO) {
        Pessoa pessoa = this.pessoaService.create(pessoaDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(pessoa).toUri();
        return ResponseEntity.created(uri).build();
    }
}
