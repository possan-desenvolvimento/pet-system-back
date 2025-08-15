package com.petsystem.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class VendaDTO {

    private Long id;
    private String cliente; // Corresponde a "cliente" no JSON
    private LocalDate data; // Corresponde a "data" no JSON
    private List<VendaItemDTO> itens; // Corresponde a "itens" no JSON
    private BigDecimal total; // Corresponde a "total" no JSON
    private String formaPagamento; // Corresponde a "formaPagamento" no JSON

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public List<VendaItemDTO> getItens() {
        return itens;
    }

    public void setItens(List<VendaItemDTO> itens) {
        this.itens = itens;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
}