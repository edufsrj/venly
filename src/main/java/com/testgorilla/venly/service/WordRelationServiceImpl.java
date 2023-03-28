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

        if (!dto.w1().matches("^[a-zA-Z\\s]+$")) {
            throw new IllegalAccessException("Invalid words");
        }

        if (!dto.w2().matches("^[a-zA-Z\\s]+$")) {
            throw new IllegalAccessException("Invalid words");
        }

        var model = toModel(dto);
        checkInverse(model);

        return toDTO(repository.save(model));
    }

    @Override
    public List<WordRelationDTO> findAll() {
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
        return new WordRelation(dto.w1(), dto.w2(), WordType.valueOf(dto.type().toUpperCase()));
    }
    public WordRelationDTO toDTO(WordRelation model) {
        return new WordRelationDTO(model.getWord1(),
                model.getWord2(),
                model.getType());
    }

    private void checkInverse(WordRelation model) {
        boolean inverseExists = repository.findAll().stream()
                .anyMatch(relation -> relation.getWord1().equals(model.getWord2()) && relation.getWord2().equals(model.getWord1()));

        if (inverseExists) {
            throw new IllegalArgumentException("Inverse relation is not allowed!");
        }
    }
}
