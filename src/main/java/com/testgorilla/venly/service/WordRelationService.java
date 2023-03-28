package com.testgorilla.venly.service;

import com.testgorilla.venly.common.dto.WordRelationDTO;

import java.util.List;

public interface WordRelationService {

    WordRelationDTO create(WordRelationDTO dto);

    List<WordRelationDTO> FindAll();

    List<WordRelationDTO> findByType(String type);
}
