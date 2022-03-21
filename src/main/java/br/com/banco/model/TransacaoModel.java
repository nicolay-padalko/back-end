package br.com.banco.model;

import br.com.banco.model.enuns.TipoTransacao;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "TB_TRANSACAO")
public class TransacaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "transacao_id")
    private Long id;

    @Column(name = "data_transacao")
    @CreationTimestamp
    private LocalDate dataTransacao;

    private Double valor;

    @ManyToOne
    @JoinColumn(name = "conta_id")
    private ContaModel contaModel;

    @Enumerated(EnumType.STRING)
    private TipoTransacao tipoTransacao;

    public TransacaoModel(LocalDate dataTransacao, Double valor, ContaModel contaModel, TipoTransacao tipoTransacao) {
        this.dataTransacao = dataTransacao;
        this.valor = valor;
        this.contaModel = contaModel;
        this.tipoTransacao = tipoTransacao;
    }

    public TransacaoModel() {
    }
}
