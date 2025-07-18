package com.petsystem.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StockItemDTO {
    private Long id;
    private String nome;
    private String descricao;
    private String tipo;
    private String categoria;
    private Integer estoqueAtual;
    private Integer estoqueMinimo;
    private Double precoCusto;
    private Double precoVenda;
}