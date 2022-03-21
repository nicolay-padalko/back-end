package br.com.banco.dtos;

import br.com.banco.model.ContaModel;
import br.com.banco.model.enuns.TipoTransacao;
import lombok.Data;


@Data
public class TransacaoDto {


    private Double valor;

    private ContaModel contaModel;

    private TipoTransacao tipoTransacao;

}
