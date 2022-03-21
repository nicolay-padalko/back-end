package br.com.banco.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "conta")
public class ContaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "conta_id")
    private int id;

    @Column(name = "nome_responsavel")
    private String nome;

    private Double saldo;




}
