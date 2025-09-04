package com.petsystem.service;

import com.petsystem.model.Agendamento;
import com.petsystem.repository.AgendamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendamentoService {

    private final AgendamentoRepository repository;

    public AgendamentoService(AgendamentoRepository repository) {
        this.repository = repository;
    }

    public List<Agendamento> listarTodos() {
        return repository.findAll();
    }

    public Optional<Agendamento> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Agendamento salvar(Agendamento agendamento) {
        return repository.save(agendamento);
    }

    public Agendamento atualizar(Long id, Agendamento agendamento) {
        return repository.findById(id).map(existing -> {
            if (agendamento.getTelefoneCliente() != null) existing.setTelefoneCliente(agendamento.getTelefoneCliente());
            if (agendamento.getNomePet() != null) existing.setNomePet(agendamento.getNomePet());
            if (agendamento.getServico() != null) existing.setServico(agendamento.getServico());
            if (agendamento.getData() != null) existing.setData(agendamento.getData());
            if (agendamento.getHora() != null) existing.setHora(agendamento.getHora());
            if (agendamento.getObservacoes() != null) existing.setObservacoes(agendamento.getObservacoes());
            if (agendamento.getStatus() != null) existing.setStatus(agendamento.getStatus());
            return repository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Agendamento não encontrado"));
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
