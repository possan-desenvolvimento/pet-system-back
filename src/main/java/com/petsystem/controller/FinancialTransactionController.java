package com.petsystem.controller;

import com.petsystem.dto.FinancialTransactionDTO;
import com.petsystem.service.FinancialTransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/financeiro")
@CrossOrigin(origins = "*")
public class FinancialTransactionController {

    private final FinancialTransactionService service;

    public FinancialTransactionController(FinancialTransactionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<FinancialTransactionDTO> salvar(@RequestBody FinancialTransactionDTO dto) {
        return ResponseEntity.ok(service.salvar(dto));
    }

    @GetMapping
    public ResponseEntity<List<FinancialTransactionDTO>> listarTodos() {
        return ResponseEntity.ok(service.buscarTodos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<FinancialTransactionDTO> editar(@PathVariable Long id, @RequestBody FinancialTransactionDTO dto) {
        return ResponseEntity.ok(service.editar(id, dto));
    }
}
