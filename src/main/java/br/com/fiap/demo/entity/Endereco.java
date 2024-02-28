package br.com.fiap.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TB_2TDSPJ_ENDERECO")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "SQ_ENDERECO")
    @SequenceGenerator(
            name = "SQ_ENDERECO",
            sequenceName = "SQ_ENDERECO",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "ID_ENDERECO")
    private Long id;

    @Column(name = "CEP")
    private String cep;

    @Column(name = "NUMERO")
    private String numero;

    @Column(name = "COMPLEMENTO")
    private String complemento;


    @OneToOne(
            fetch = FetchType.EAGER,
            cascade = {CascadeType.ALL}
    )
    @JoinColumn(
            name = "CLIENTE",
            referencedColumnName = "ID_CLIENTE",
            foreignKey = @ForeignKey(
                    name = "FK_ENDERECO_CLIENTE"
            )
    )
    private Cliente cliente;


}
