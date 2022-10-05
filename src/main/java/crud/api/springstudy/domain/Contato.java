package crud.api.springstudy.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Contato {

    @Id
    @NonNull
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column
    private String nome;

    @NonNull
    @Column
    private String telefone;

    @NonNull
    @Column
    private String email;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Pessoa pessoa;
}
