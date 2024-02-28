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
@Table(name = "TB_2TDSPJ_TELEFONE")
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "SQ_TELEFONE")
    @SequenceGenerator(
            name = "SQ_TELEFONE",
            sequenceName = "SQ_TELEFONE",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "ID_TELEFONE")
    private Long id;

    private String ddi;

    private String ddd;

    private String numero;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(
            name = "CLIENTE",
            referencedColumnName = "ID_CLIENTE",
            foreignKey = @ForeignKey(name = "FK_CLIENTE_TELEFONE")
    )
    private Cliente cliente;


}
