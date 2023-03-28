package com.testgorilla.venly.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class WordRelation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String word1;
    private String word2;
    @Enumerated(EnumType.STRING)
    private String type;

}
