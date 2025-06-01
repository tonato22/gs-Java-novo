
package com.example.api.service;

import com.example.api.model.Psicologo;
import com.example.api.repository.PsicologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PsicologoService {

    @Autowired
    private PsicologoRepository repository;

    public List<Psicologo> listarTodos() {
        return repository.findAll();
    }

    public Optional<Psicologo> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Psicologo salvar(Psicologo psicologo) {
        return repository.save(psicologo);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
