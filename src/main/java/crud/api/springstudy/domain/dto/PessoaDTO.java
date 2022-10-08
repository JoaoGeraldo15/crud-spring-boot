package crud.api.springstudy.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO {

    private Long id;

    private String nome;

    private String cpf;

    private Date dataNascimento;

    private List<ContatoDTO> contatos = new ArrayList<>();

}
