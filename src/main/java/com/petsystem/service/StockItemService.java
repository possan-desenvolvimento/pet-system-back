//package com.petsystem.service;
//
//import com.petsystem.dto.StockItemDTO;
//import com.petsystem.mapper.StockItemMapper;
//import com.petsystem.repository.StockItemRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@RequiredArgsConstructor
//public class StockItemService {
//
//    private final StockItemRepository repository;
//
//    public List<StockItemDTO> listarTodos() {
//        return repository.findAll()
//                .stream()
//                .map(StockItemMapper::toDTO)
//                .collect(Collectors.toList());
//    }
//
////    public StockItemDTO salvar(StockItemDTO dto) {
////        var entity = StockItemMapper.toEntity(dto);
////        var salvo = repository.save(entity);
////        return StockItemMapper.toDTO(salvo);
////    }
//
//
//
//    public void deletar(Long id) {
//        repository.deleteById(id);
//    }
//
//    public StockItemDTO buscarPorId(Long id) {
//        return repository.findById(id)
//                .map(StockItemMapper::toDTO)
//                .orElse(null);
//    }
//}

package com.petsystem.service;

import com.petsystem.dto.StockItemDTO;
import com.petsystem.mapper.StockItemMapper;
import com.petsystem.repository.StockItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StockItemService {

    private final StockItemRepository repository;

    public List<StockItemDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(StockItemMapper::toDTO)
                .collect(Collectors.toList());
    }

    public StockItemDTO salvar(StockItemDTO dto) {
        System.out.println("DTO recebido para salvar: " + dto); // <- Aqui o log!
        var entity = StockItemMapper.toEntity(dto);
        var salvo = repository.save(entity);
        return StockItemMapper.toDTO(salvo);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public StockItemDTO buscarPorId(Long id) {
        return repository.findById(id)
                .map(StockItemMapper::toDTO)
                .orElse(null);
    }
}
