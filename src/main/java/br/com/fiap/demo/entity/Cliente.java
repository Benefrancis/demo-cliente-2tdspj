package br.com.fiap.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "TB_2TDSPJ_CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "SQ_CLIENTE")
    @SequenceGenerator(name = "SQ_CLIENTE",
            sequenceName = "SQ_CLIENTE")
    @Column(name = "ID_CLIENTE")
    private Long id;

    @Column(name = "NM_CLIENTE")
    private String nome;

    @Column(name = "DT_NASCIMENTO")
    private LocalDate dataNascimento;

    @OneToOne(
            fetch = FetchType.EAGER,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST}
    )
    @JoinColumn(
            name = "ENDERECO",
            referencedColumnName = "ID_ENDERECO",
            foreignKey = @ForeignKey(
                    name = "FK_ENDERECO_CLIENTE"
            )
    )
    private Endereco endereco;

}
