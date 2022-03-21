package br.com.banco.dtos;

import br.com.banco.model.ContaModel;
import br.com.banco.model.enuns.Tipo;
import lombok.Data;


@Data
public class TransferenciaDto {


    private Double valor;

    private ContaModel contaModel;

    private Tipo tipo;

}
