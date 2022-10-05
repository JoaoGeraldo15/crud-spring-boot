package crud.api.springstudy.domain;

import lombok.*;
import org.hibernate.validator.constraints.Length;

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
    @NonNull
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column
    private String nome;

    @NonNull
    @Size(min = 11, max = 11)
    @Column
    private String cpf;

    @NonNull
    @Column
    private Date dataNascimento;

    @NonNull
    @OneToMany
    @JoinColumn(nullable = false)
    private List<Contato> contatos = new ArrayList<>();

}
