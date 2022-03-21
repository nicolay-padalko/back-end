package br.com.banco.service;

import br.com.banco.model.TranferenciaModel;
import br.com.banco.repository.TransferenciaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class TransferenciaService {

    final TransferenciaRepository transferenciaRepository;

    public TransferenciaService(TransferenciaRepository transferenciaRepository) {
        this.transferenciaRepository = transferenciaRepository;
    }

    @Transactional
    public TranferenciaModel save(TranferenciaModel tranferenciaModel) {
        return transferenciaRepository.save(tranferenciaModel);
    }

    public Page<TranferenciaModel> findAll(Pageable pageable) {
        return transferenciaRepository.findAll(pageable);
    }

    public Optional<TranferenciaModel> findById(int id) {
        return transferenciaRepository.findById((long) id);
    }
}
