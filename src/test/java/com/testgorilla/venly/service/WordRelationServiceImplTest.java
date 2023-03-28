package com.testgorilla.venly.service;

import com.testgorilla.venly.common.WordType;
import com.testgorilla.venly.common.dto.WordRelationDTO;
import com.testgorilla.venly.model.WordRelation;
import com.testgorilla.venly.repository.WordRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class WordRelationServiceImplTest {

    @InjectMocks
    private WordRelationServiceImpl service;

    @Mock
    private WordRepository repository;

    WordRelationDTO dto;

    WordRelation wordRelation;

    @BeforeAll
    void setup() {
        dto = new WordRelationDTO("son", "daughter", "antonym");
        wordRelation = new WordRelation("son", "daughter", WordType.ANTONYM);
    }

    @Test
    void should_save_relation() throws IllegalAccessException {
        //when
        when(repository.save(any(WordRelation.class))).thenReturn(wordRelation);

        //assert
        service.create(dto);
        verify(repository, times(1)).save(any(WordRelation.class));
    }

    @Test
    void should_get_all() throws IllegalAccessException {
        //given
        var list = List.of(wordRelation, new WordRelation());

        //when
        when(repository.findAll()).thenReturn(list);

        //assert
        assertThat(service.findAll()).hasSize(2);
        verify(repository, times(1)).findAll();
        verifyNoMoreInteractions(repository);
    }
}