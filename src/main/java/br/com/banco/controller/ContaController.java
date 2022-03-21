package br.com.banco.controller;

import br.com.banco.model.ContaModel;
import br.com.banco.repository.ContaRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContaController {

    private final ContaRepository contaRepository;

    public ContaController(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    @PostMapping("/transacoes")
    public ContaModel createconta(@RequestBody ContaModel contaModel) {
        return contaRepository.save(contaModel);
    }

}
