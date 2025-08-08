package com.petsystem.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FinancialTransactionDTO {

    private Long id;

    private String tipo;

    private String categoria;

    private String descricao;

    private BigDecimal valor;

    private LocalDate data;

    private String formaPagamento;
}
