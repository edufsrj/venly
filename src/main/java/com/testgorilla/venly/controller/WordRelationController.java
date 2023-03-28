package com.testgorilla.venly.controller;

import com.testgorilla.venly.common.dto.WordRelationDTO;
import com.testgorilla.venly.service.WordRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("word")
public class WordRelationController {

    @Autowired
    private WordRelationService service;

    @PostMapping("/")
    public ResponseEntity<WordRelationDTO> wordRcreateelations(WordRelationDTO dto) {
        return new ResponseEntity<>(service.create(dto), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<WordRelationDTO>> list(WordRelationDTO dto) {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }
}
