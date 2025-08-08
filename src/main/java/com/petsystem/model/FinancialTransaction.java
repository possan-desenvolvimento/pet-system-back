package com.petsystem.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "financial_transaction")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FinancialTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo; // entrada ou saida

    private String categoria;

    private String descricao;

    private BigDecimal valor;

    private LocalDate data;

    private String formaPagamento;
}
