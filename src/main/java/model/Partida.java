/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author muril
 */
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_partida")
public class Partida implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime dataHora;

    private String resultado;

    @ManyToOne
    @JoinColumn(name = "jogador1_id")
    private Jogador jogador1;

    @ManyToOne
    @JoinColumn(name = "jogador2_id")
    private Jogador jogador2;

    @ManyToOne
    @JoinColumn(name = "torneio_id")
    private Torneio torneio;

    public Partida() {}

    // Getters e setters
}

