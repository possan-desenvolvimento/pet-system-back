package com.petsystem.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StockItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private String tipo; // "produto" ou "servico"
    private String categoria;

    private Integer estoqueAtual;
    private Integer estoqueMinimo;

    private Double precoCusto;
    private Double precoVenda;
}