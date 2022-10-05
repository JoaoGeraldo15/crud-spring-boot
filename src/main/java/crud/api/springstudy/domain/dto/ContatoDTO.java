package crud.api.springstudy.domain.dto;

import crud.api.springstudy.domain.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContatoDTO {

    private Long id;

    private String nome;

    private String telefone;

    private String email;

    private Pessoa pessoa;

}
