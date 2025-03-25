package com.allan.inovatech.controller;

import com.allan.inovatech.dto.profile.TaskProfileDTO;
import com.allan.inovatech.dto.request.get.TaskGetDTO;
import com.allan.inovatech.dto.request.post.TaskPostDTO;
import com.allan.inovatech.model.entities.TaskKanban;
import com.allan.inovatech.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/create")
    public ResponseEntity<TaskGetDTO> createTask(@RequestBody TaskPostDTO dto){
        TaskKanban taskKanban = taskService.createTask(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(TaskGetDTO.fromEntity(taskKanban));
    }
}
