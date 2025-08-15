package com.petsystem.service;

import com.petsystem.dto.VendaDTO;
import com.petsystem.dto.VendaItemDTO;
import com.petsystem.model.Venda;
import com.petsystem.model.VendaItem;
import com.petsystem.repository.VendaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendaService {

    private final VendaRepository vendaRepository;

    public VendaService(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    @Transactional
    public VendaDTO salvar(VendaDTO dto) {
        // 1. Mapeia o VendaDTO para a entidade Venda
        Venda venda = new Venda();
        venda.setCliente(dto.getCliente());
        venda.setData(dto.getData());
        venda.setTotal(dto.getTotal());
        venda.setFormaPagamento(dto.getFormaPagamento());

        // 2. Mapeia a lista de VendaItemDTO para VendaItem e associa à Venda
        List<VendaItem> itens = dto.getItens().stream().map(itemDto -> {
            VendaItem item = new VendaItem();
            item.setProduto(itemDto.getProduto());
            item.setQuantidade(itemDto.getQuantidade());
            item.setPrecoUnitario(itemDto.getPrecoUnitario());
            item.setVenda(venda); // Associa o item à venda principal
            return item;
        }).collect(Collectors.toList());

        venda.setItens(itens); // Define a lista de itens na entidade Venda

        // 3. Salva a entidade Venda (e os itens são salvos em cascata)
        Venda saved = vendaRepository.save(venda);

        // 4. Converte a entidade salva de volta para DTO para retornar
        return mapToDTO(saved);
    }

    public List<VendaDTO> listar() {
        return vendaRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public void excluir(Long id) {
        vendaRepository.deleteById(id);
    }

    // Método auxiliar para mapear a entidade Venda para VendaDTO
    private VendaDTO mapToDTO(Venda venda) {
        List<VendaItemDTO> itensDto = venda.getItens().stream().map(item -> {
            VendaItemDTO itemDto = new VendaItemDTO();
            itemDto.setProduto(item.getProduto());
            itemDto.setQuantidade(item.getQuantidade());
            itemDto.setPrecoUnitario(item.getPrecoUnitario());
            return itemDto;
        }).collect(Collectors.toList());

        VendaDTO vendaDto = new VendaDTO();
        vendaDto.setId(venda.getId());
        vendaDto.setCliente(venda.getCliente());
        vendaDto.setData(venda.getData());
        vendaDto.setItens(itensDto);
        vendaDto.setTotal(venda.getTotal());
        vendaDto.setFormaPagamento(venda.getFormaPagamento());

        return vendaDto;
    }
}