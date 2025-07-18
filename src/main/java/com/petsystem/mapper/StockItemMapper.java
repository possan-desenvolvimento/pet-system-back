package com.petsystem.mapper;

import com.petsystem.dto.StockItemDTO;
import com.petsystem.model.StockItem;

public class StockItemMapper {

    public static StockItem toEntity(StockItemDTO dto) {
        return StockItem.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .descricao(dto.getDescricao())
                .tipo(dto.getTipo())
                .categoria(dto.getCategoria())
                .estoqueAtual(dto.getEstoqueAtual())
                .estoqueMinimo(dto.getEstoqueMinimo())
                .precoCusto(dto.getPrecoCusto())
                .precoVenda(dto.getPrecoVenda())
                .build();
    }

    public static StockItemDTO toDTO(StockItem entity) {
        return StockItemDTO.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .descricao(entity.getDescricao())
                .tipo(entity.getTipo())
                .categoria(entity.getCategoria())
                .estoqueAtual(entity.getEstoqueAtual())
                .estoqueMinimo(entity.getEstoqueMinimo())
                .precoCusto(entity.getPrecoCusto())
                .precoVenda(entity.getPrecoVenda())
                .build();
    }
}