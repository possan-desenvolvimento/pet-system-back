package com.petsystem.mapper;

import com.petsystem.dto.FinancialTransactionDTO;
import com.petsystem.model.FinancialTransaction;

public class FinancialTransactionMapper {

    public static FinancialTransaction toEntity(FinancialTransactionDTO dto) {
        return FinancialTransaction.builder()
                .id(dto.getId())
                .tipo(dto.getTipo())
                .categoria(dto.getCategoria())
                .descricao(dto.getDescricao())
                .valor(dto.getValor())
                .data(dto.getData())
                .formaPagamento(dto.getFormaPagamento())
                .build();
    }

    public static FinancialTransactionDTO toDTO(FinancialTransaction entity) {
        return FinancialTransactionDTO.builder()
                .id(entity.getId())
                .tipo(entity.getTipo())
                .categoria(entity.getCategoria())
                .descricao(entity.getDescricao())
                .valor(entity.getValor())
                .data(entity.getData())
                .formaPagamento(entity.getFormaPagamento())
                .build();
    }
}
