package crud.api.springstudy.domain;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pessoa {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column
    private String nome;

    @NonNull
    @Size(min = 11, max = 11, message = "O CPF deve conter 11 dígitos")
    @Column
    @CPF(message = "CPF informado é inválido")
    private String cpf;

    @NonNull
    @Column
    private Date dataNascimento;

    @NonNull
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(nullable = false)
    private List<Contato> contatos = new ArrayList<>();

}
