package br.com.fiap.demo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_2TDSPJ_TELEFONE")

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TELEFONE")
    @SequenceGenerator(
            name = "SQ_TELEFONE",
            sequenceName = "SQ_TELEFONE",
            initialValue = 1,
            allocationSize = 1
    )
    @Column(name = "ID_TELEFONE")
    private Long id;

    private String ddi;

    private String ddd;

    private String numero;

    @ManyToOne
    @JoinColumn(
            name = "CLIENTE",
            referencedColumnName = "ID_CLIENTE",
            foreignKey = @ForeignKey(name = "FK_TELEFONE_CLIENTE")
    )
    private Cliente cliente;

}
