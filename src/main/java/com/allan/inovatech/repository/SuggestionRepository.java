package com.allan.inovatech.repository;

import com.allan.inovatech.model.entities.Suggestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuggestionRepository extends JpaRepository<Suggestion, Integer> {
}
