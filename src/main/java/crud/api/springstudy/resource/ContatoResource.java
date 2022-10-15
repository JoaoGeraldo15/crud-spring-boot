package crud.api.springstudy.resource;

import crud.api.springstudy.domain.dto.ContatoDTO;
import crud.api.springstudy.service.ContatoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "contato")
@AllArgsConstructor
public class ContatoResource {

    public static final String ID = "/{id}";
    private ContatoService contatoService;

    @GetMapping(value = ID)
    public ResponseEntity<ContatoDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(this.contatoService.findById(id));
    }
}
