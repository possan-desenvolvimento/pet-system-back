package com.petsystem.controller;

import com.petsystem.dto.StockItemDTO;
import com.petsystem.service.StockItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estoque")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class StockItemController {

    private final StockItemService service;

    @GetMapping
    public List<StockItemDTO> listarTodos() {
        return service.listarTodos();
    }

    @PostMapping
    public StockItemDTO salvar(@RequestBody StockItemDTO dto) {
        return service.salvar(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StockItemDTO> atualizar(@PathVariable Long id, @RequestBody StockItemDTO dto) {
        dto.setId(id); // garante que o ID venha corretamente
        StockItemDTO atualizado = service.salvar(dto); // reaproveita o método salvar
        return ResponseEntity.ok(atualizado);
    }


    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    @GetMapping("/{id}")
    public StockItemDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
}