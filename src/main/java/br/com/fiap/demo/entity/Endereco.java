package br.com.fiap.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "TB_2TDSPJ_ENDERECO")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "SQ_ENDERECO")
    @SequenceGenerator(
            name = "SQ_ENDERECO",
            sequenceName = "SQ_ENDERECO")
    @Column(name = "ID_ENDERECO")
    private Long id;

    @Column(name = "CEP")
    private String cep;

    @Column(name = "NUMERO")
    private String numero;

    @Column(name = "COMPLEMENTO")
    private String complemento;

}
