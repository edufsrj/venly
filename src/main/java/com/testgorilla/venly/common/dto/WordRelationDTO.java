package com.testgorilla.venly.common.dto;

import com.testgorilla.venly.model.WordRelation;

import java.util.Objects;

public record WordRelationDTO(
        String w1,
        String w2,
        String type
) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WordRelation)) return false;
        WordRelationDTO that = (WordRelationDTO) o;
        return Objects.equals(w1, that.w1) && Objects.equals(w2, that.w2) && type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(w1, w2, type);
    }
}
