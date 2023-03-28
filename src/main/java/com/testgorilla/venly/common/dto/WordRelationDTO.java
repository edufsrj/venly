package com.testgorilla.venly.common.dto;

import lombok.Builder;

@Builder
public record WordRelationDTO(
        String w1,
        String w2,
        String type
) {

}
