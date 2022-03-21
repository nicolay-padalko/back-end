package br.com.banco.controller;

import br.com.banco.dtos.TransferenciaDto;
import br.com.banco.model.TranferenciaModel;
import br.com.banco.service.TransferenciaService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class TransferenciaController {

    private final TransferenciaService transferenciaService;

    public TransferenciaController(TransferenciaService transferenciaService) {
        this.transferenciaService = transferenciaService;
    }


    @GetMapping("/transferencia")
    public ResponseEntity<Page<TranferenciaModel>> getAllTransferencias(@PageableDefault(
            page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(transferenciaService.findAll(pageable));
    }

    @PostMapping("/transferencia")
    public ResponseEntity<Object> saveTransferencia(@RequestBody TransferenciaDto tranferenciaDto) {

        var transferenciaModel = new TranferenciaModel();
        BeanUtils.copyProperties(tranferenciaDto, transferenciaModel);
        transferenciaModel.setDataTransacao(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(transferenciaService.save(transferenciaModel));
    }


    @GetMapping("/transferencia/{id}")
    public ResponseEntity<Object> getOneTransferencia(@PathVariable(value = "id") int id){
        Optional<TranferenciaModel> tranferenciaModelOptional = transferenciaService.findById(id);
        if (!tranferenciaModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Transferencia náo encontrada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(tranferenciaModelOptional.get());
    }
}
