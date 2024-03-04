package br.com.fiap.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TB_2TDSPJ_CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "SQ_CLIENTE")
    @SequenceGenerator(name = "SQ_CLIENTE",
            sequenceName = "SQ_CLIENTE",
            initialValue = 1,
            allocationSize = 1
    )
    @Column(name = "ID_CLIENTE")
    private Long id;

    @Column(name = "NM_CLIENTE")
    private String nome;

    @Column(name = "DT_NASCIMENTO")
    private LocalDate dataNascimento;

}
