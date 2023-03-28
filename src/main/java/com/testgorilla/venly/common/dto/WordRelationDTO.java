package com.testgorilla.venly.common.dto;

import com.testgorilla.venly.common.WordType;
import lombok.Builder;

@Builder
public record WordRelationDTO(
        String w1,
        String w2,
        WordType type
) {

}
