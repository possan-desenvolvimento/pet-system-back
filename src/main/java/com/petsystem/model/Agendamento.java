package com.petsystem.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "agendamentos")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(nullable = false)
//    private Long clienteId;

    @Column(nullable = false)
    private String telefoneCliente;

    @Column(nullable = false)
    private String nomePet;

    @Column(nullable = false)
    private String servico;

    @Column(nullable = false)
    private LocalDate data;

    @Column(nullable = false)
    private LocalTime hora;

    @Column(columnDefinition = "TEXT")
    private String observacoes;

    @Column(nullable = false)
    private String status; // Pendente, Confirmado, Concluído, Cancelado

    public Agendamento() {}

    public Agendamento(String telefoneCliente, String nomePet, String servico, LocalDate data, LocalTime hora, String observacoes, String status) {
        this.telefoneCliente = telefoneCliente;
        this.nomePet = nomePet;
        this.servico = servico;
        this.data = data;
        this.hora = hora;
        this.observacoes = observacoes;
        this.status = status;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;

    }

    public String getNomePet() {
        return nomePet;
    }

    public void setNomePet(String nomePet) {
        this.nomePet = nomePet;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
