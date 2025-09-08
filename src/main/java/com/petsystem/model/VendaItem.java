//package com.petsystem.model;
//
//import jakarta.persistence.*;
//import java.math.BigDecimal;
//
//@Entity
//@Table(name = "venda_itens")
//public class VendaItem {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "venda_id")
//    private Venda venda;
//
//    private String produto;
//    private Integer quantidade;
//    private BigDecimal precoUnitario;
//
//    // Construtor padrão
//    public VendaItem() {}
//
//    // Construtor completo
//    public VendaItem(String produto, Integer quantidade, BigDecimal precoUnitario) {
//        this.produto = produto;
//        this.quantidade = quantidade;
//        this.precoUnitario = precoUnitario;
//    }
//
//    // Getters e Setters
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Venda getVenda() {
//        return venda;
//    }
//
//    public void setVenda(Venda venda) {
//        this.venda = venda;
//    }
//
//    public String getProduto() {
//        return produto;
//    }
//
//    public void setProduto(String produto) {
//        this.produto = produto;
//    }
//
//    public Integer getQuantidade() {
//        return quantidade;
//    }
//
//    public void setQuantidade(Integer quantidade) {
//        this.quantidade = quantidade;
//    }
//
//    public BigDecimal getPrecoUnitario() {
//        return precoUnitario;
//    }
//
//    public void setPrecoUnitario(BigDecimal precoUnitario) {
//        this.precoUnitario = precoUnitario;
//    }
//}

package com.petsystem.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "venda_itens")
public class VendaItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venda_id")
    private Venda venda;

    private String produto;
    private Integer quantidade;

    // Anotação para mapear 'precoUnitario' para a coluna 'preco_unitario' no banco
    @Column(name = "preco_unitario")
    private BigDecimal precoUnitario;

    // Construtor padrão
    public VendaItem() {}

    // Construtor completo
    public VendaItem(String produto, Integer quantidade, BigDecimal precoUnitario) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }
}