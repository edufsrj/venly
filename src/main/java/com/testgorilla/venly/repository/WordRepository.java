package com.testgorilla.venly.repository;

import com.testgorilla.venly.model.WordRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends JpaRepository<WordRelation, Long> {
}
