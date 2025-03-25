package com.allan.inovatech.service;

import com.allan.inovatech.dto.profile.TaskProfileDTO;
import com.allan.inovatech.dto.request.post.TaskPostDTO;
import com.allan.inovatech.model.entities.Adm;
import com.allan.inovatech.model.entities.TaskKanban;
import com.allan.inovatech.repository.AdmRepository;
import com.allan.inovatech.repository.TaskKanbanRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskKanbanRepository taskRepository;

    @Autowired
    private AdmRepository admRepository;

    public TaskKanban createTask(TaskPostDTO dto){
        TaskKanban task = new TaskKanban();
        Adm adm = admRepository.findById(dto.idAdm()).orElseThrow(()
                -> new EntityNotFoundException("Student not found"));
        task.setTitle(dto.title());
        task.setTaskDescription(dto.taskDescription());
        task.setAdm(adm);
        return taskRepository.save(task);
    }
}
