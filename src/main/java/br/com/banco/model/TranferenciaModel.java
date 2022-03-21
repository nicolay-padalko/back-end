package br.com.banco.model;

import br.com.banco.model.enuns.Tipo;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "transferencia")
public class TranferenciaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "transacao_id")
    private int id;

    @Column(name = "data_transferencia")
    @CreationTimestamp
    private LocalDateTime dataTransacao;

    private Double valor;

    @ManyToOne
    @JoinColumn(name = "conta_id")
    private ContaModel contaModel;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;

}
