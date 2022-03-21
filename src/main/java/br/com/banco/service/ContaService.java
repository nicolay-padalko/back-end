package br.com.banco.service;

import br.com.banco.repository.ContaRepository;

public class ContaService {

    final ContaRepository contaRepository;

    public ContaService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }
}
