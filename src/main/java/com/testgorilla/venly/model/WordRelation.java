package com.testgorilla.venly.model;

import com.testgorilla.venly.common.WordType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "word1", "word2" }) })
@Getter
@Setter
@NoArgsConstructor
public class WordRelation {

    public WordRelation(String word1, String word2, WordType type) {
        this.word1 = Objects.requireNonNull(word1);
        this.word2 = Objects.requireNonNull(word2);

        if (type == WordType.SYNONYM && word1.equals(word2)) {
            throw new IllegalArgumentException("Synonyms must have different words");
        }

        if (type == WordType.ANTONYM && word1.equals(word2)) {
            throw new IllegalArgumentException("Antonyms must have different words");
        }

        if (type == WordType.RELATED && word1.equals(word2)) {
            throw new IllegalArgumentException("Antonyms must have different words");
        }

        this.type = Objects.requireNonNull(type.name().toLowerCase());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String word1;
    private String word2;
    private String type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WordRelation)) return false;
        WordRelation that = (WordRelation) o;
        return Objects.equals(word1, that.word1) && Objects.equals(word2, that.word2) && type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(word1, word2, type);
    }
}
