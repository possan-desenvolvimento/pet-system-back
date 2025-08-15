package com.petsystem.dto;

import java.math.BigDecimal;

public class VendaItemDTO {

    private String produto; // Corresponde a "produto" no JSON
    private int quantidade; // Corresponde a "quantidade" no JSON
    private BigDecimal precoUnitario; // Corresponde a "precoUnitario" no JSON

    // Getters e Setters
    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }
}