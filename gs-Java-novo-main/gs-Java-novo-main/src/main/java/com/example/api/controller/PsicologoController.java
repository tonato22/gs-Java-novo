
package com.example.api.controller;

import com.example.api.model.Psicologo;
import com.example.api.service.PsicologoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/psicologos")
public class PsicologoController {

    @Autowired
    private PsicologoService service;

    @GetMapping
    public List<Psicologo> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Psicologo buscar(@PathVariable Long id) {
        return service.buscarPorId(id).orElseThrow();
    }

    @PostMapping
    public Psicologo criar(@RequestBody @Valid Psicologo psicologo) {
        return service.salvar(psicologo);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
