package com.testgorilla.venly.service;

import com.testgorilla.venly.common.WordType;
import com.testgorilla.venly.common.dto.WordRelationDTO;
import com.testgorilla.venly.model.WordRelation;
import com.testgorilla.venly.repository.WordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordRelationServiceImpl implements WordRelationService {

    final WordRepository repository;

    public WordRelationServiceImpl(WordRepository repository) {
        this.repository = repository;
    }

    public WordRelationDTO create(WordRelationDTO dto) throws IllegalAccessException {

        if (!dto.w1().matches("^[a-zA-Z]+$") && !dto.w1().matches("^[a-zA-Z]+$")) {
            throw new IllegalAccessException("Invalid words");
        }

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
        return new WordRelation(dto.w1(), dto.w2(), WordType.valueOf(dto.type()));
    }
    public WordRelationDTO toDTO(WordRelation model) {
        return WordRelationDTO.builder()
                .w1(model.getWord1())
                .w2(model.getWord2())
                .type(model.getType())
                .build();
    }


}
