package com.testgorilla.venly.service;

import com.testgorilla.venly.common.dto.WordRelationDTO;
import com.testgorilla.venly.model.WordRelation;
import com.testgorilla.venly.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordRelationServiceImpl implements WordRelationService {

    @Autowired
    WordRepository repository;

    public WordRelationDTO create(WordRelationDTO dto) {
        var model = toModel(dto);

        return toDTO(repository.save(model));
    }

    @Override
    public List<WordRelationDTO> FindAll() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    @Override
    public List<WordRelationDTO> findByType(String type) {
        return repository.findByType(type)
                .stream()
                .map(this::toDTO)
                .toList();
    }


    public WordRelation toModel(WordRelationDTO dto) {
        return WordRelation.builder()
                .word1(dto.w1())
                .word2(dto.w2())
                .type(dto.type())
                .build();
    }
    public WordRelationDTO toDTO(WordRelation model) {
        return WordRelationDTO.builder()
                .w1(model.getWord1())
                .w2(model.getWord2())
                .type(model.getType())
                .build();
    }


}
