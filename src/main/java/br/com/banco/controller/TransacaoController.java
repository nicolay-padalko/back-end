package br.com.banco.controller;

import br.com.banco.exception.ResourceNotFoundException;
import br.com.banco.model.TransacaoModel;
import br.com.banco.repository.TransacaoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TransacaoController {

    private final TransacaoRepository transacaoRepository;

    public TransacaoController(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    @GetMapping("/transacoes")
    public List<TransacaoModel> getAllTransacoes() {
        return transacaoRepository.findAll();
    }

    @PostMapping("/transacoes")
    public TransacaoModel createTransacao(@RequestBody TransacaoModel transacaoModel) {
        return transacaoRepository.save(transacaoModel);
    }

    @GetMapping("/transacoes/{id}")
    public ResponseEntity<TransacaoModel> getTransacaoById(@PathVariable Long id) {
        TransacaoModel transacaoModel =transacaoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transação com o id: " + id + "não existe"));
        return ResponseEntity.ok(transacaoModel);
    }
}
