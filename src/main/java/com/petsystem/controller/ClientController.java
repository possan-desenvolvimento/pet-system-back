package com.petsystem.controller;

import com.petsystem.dto.ClientDTO;
import com.petsystem.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/clientes")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public ClientDTO create(@RequestBody ClientDTO dto) {
        return clientService.save(dto);
    }

    @GetMapping
    public List<ClientDTO> getAll() {
        return clientService.findAll();
    }
}
