package com.testgorilla.venly.service;

import com.testgorilla.venly.common.dto.WordRelationDTO;

import java.util.List;

public interface WordRelationService {

    WordRelationDTO create(WordRelationDTO dto) throws IllegalAccessException;

    List<WordRelationDTO> findAll();

    List<WordRelationDTO> findByType(String type);
}
