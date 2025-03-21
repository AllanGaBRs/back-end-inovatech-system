package com.allan.inovatech.repository;

import com.allan.inovatech.model.entities.TaskKanban;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskKanbanRepository extends JpaRepository<TaskKanban, Integer> {
}
