package com.petsystem.service;

import com.petsystem.dto.FinancialTransactionDTO;
import com.petsystem.mapper.FinancialTransactionMapper;
import com.petsystem.model.FinancialTransaction;
import com.petsystem.repository.FinancialTransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FinancialTransactionService {

    private final FinancialTransactionRepository repository;

    public FinancialTransactionService(FinancialTransactionRepository repository) {
        this.repository = repository;
    }

    public FinancialTransactionDTO salvar(FinancialTransactionDTO dto) {
        FinancialTransaction entity = FinancialTransactionMapper.toEntity(dto);
        return FinancialTransactionMapper.toDTO(repository.save(entity));
    }

    public List<FinancialTransactionDTO> buscarTodos() {
        return repository.findAll()
                .stream()
                .map(FinancialTransactionMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public FinancialTransactionDTO editar(Long id, FinancialTransactionDTO dto) {
        FinancialTransaction entity = FinancialTransactionMapper.toEntity(dto);
        entity.setId(id);
        return FinancialTransactionMapper.toDTO(repository.save(entity));
    }
}
