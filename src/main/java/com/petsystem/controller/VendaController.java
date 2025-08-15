package com.petsystem.controller;

import com.petsystem.dto.VendaDTO;
import com.petsystem.service.VendaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendas")
@CrossOrigin(origins = "*")
public class VendaController {

    private final VendaService vendaService;

    public VendaController(VendaService vendaService) {
        this.vendaService = vendaService;
    }

    @PostMapping
    public ResponseEntity<VendaDTO> salvar(@RequestBody VendaDTO dto) {
        return ResponseEntity.ok(vendaService.salvar(dto));
    }

    @GetMapping
    public ResponseEntity<List<VendaDTO>> listar() {
        return ResponseEntity.ok(vendaService.listar());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        vendaService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}

