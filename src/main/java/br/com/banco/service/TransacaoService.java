package br.com.banco.service;

import br.com.banco.model.TransacaoModel;
import br.com.banco.repository.TransacaoRepository;

import javax.transaction.Transactional;

public class TransacaoService {

    final TransacaoRepository transacaoRepository;

    public TransacaoService(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    @Transactional
    public TransacaoModel save(TransacaoModel transacaoModel) {
        return transacaoRepository.save(transacaoModel);
    }
}
