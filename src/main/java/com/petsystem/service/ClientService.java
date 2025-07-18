package com.petsystem.service;

import com.petsystem.dto.ClientDTO;
import com.petsystem.model.Client;
import com.petsystem.model.Pet;
import com.petsystem.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public ClientDTO save(ClientDTO dto) {
        Client client = new Client();
        client.setNome(dto.getNome());
        client.setEmail(dto.getEmail());
        client.setTelefone(dto.getTelefone());
        client.setEndereco(dto.getEndereco());

        // Converter nomes dos pets em objetos Pet
        List<Pet> pets = dto.getPets().stream().map(nomePet -> {
            Pet pet = new Pet();
            pet.setNome(nomePet);
            pet.setDono(client); // Importante: associar dono
            return pet;
        }).collect(Collectors.toList());

        client.setPets(pets);
        Client saved = repository.save(client);

        // Retornar DTO atualizado
        dto.setId(saved.getId());
        return dto;
    }

    public List<ClientDTO> findAll() {
        return repository.findAll().stream().map(c -> {
            ClientDTO dto = new ClientDTO();
            dto.setId(c.getId());
            dto.setNome(c.getNome());
            dto.setEmail(c.getEmail());
            dto.setTelefone(c.getTelefone());
            dto.setEndereco(c.getEndereco());

            // Converter objetos Pet em nomes (String)
            List<String> nomesPets = c.getPets().stream()
                    .map(Pet::getNome)
                    .collect(Collectors.toList());

            dto.setPets(nomesPets);
            return dto;
        }).collect(Collectors.toList());
    }

    public ClientDTO findById(Long id) {
        Client client = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com ID: " + id));

        ClientDTO dto = new ClientDTO();
        dto.setId(client.getId());
        dto.setNome(client.getNome());
        dto.setEmail(client.getEmail());
        dto.setTelefone(client.getTelefone());
        dto.setEndereco(client.getEndereco());

        List<String> nomesPets = client.getPets().stream()
                .map(Pet::getNome)
                .collect(Collectors.toList());

        dto.setPets(nomesPets);
        return dto;
    }

    public ClientDTO update(Long id, ClientDTO dto) {
        Client client = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com ID: " + id));

        client.setNome(dto.getNome());
        client.setEmail(dto.getEmail());
        client.setTelefone(dto.getTelefone());
        client.setEndereco(dto.getEndereco());

        // Remove pets antigos
        client.getPets().clear();

        // Adiciona pets novos
        for (String nomePet : dto.getPets()) {
            Pet pet = new Pet();
            pet.setNome(nomePet);
            pet.setDono(client);
            client.getPets().add(pet);
        }

        Client updated = repository.save(client);
        dto.setId(updated.getId());
        return dto;
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Cliente não encontrado com ID: " + id);
        }
        repository.deleteById(id);
    }

}
