package com.vestas.kawit.task_lists.controller;

import com.vestas.kawit.task_lists.repository.TaskList;
import com.vestas.kawit.task_lists.service.TaskListDTO;
import com.vestas.kawit.task_lists.service.TaskListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/tasklist")
@RestController
public class TaskListController {

    private final TaskListService taskListService;

    private static final String ONLINE_LOG_NAME = "web controller";

    @Autowired
    public TaskListController(TaskListService taskListService) {
        this.taskListService = taskListService;
    }

    @GetMapping
    public List<TaskListDTO> getTaskLists(@RequestParam(required = false) String userMakingRequest, String plant, String taskList) {
        if (userMakingRequest == null) userMakingRequest = "json client";

        return taskListService.getAll(userMakingRequest, plant, taskList);
    }

    @GetMapping("/all")
    public ModelAndView taskListsGraphically() {
        ModelAndView mav = new ModelAndView("task_lists/tasklists");
        mav.addObject("TaskListsCollection", taskListService.getAll(ONLINE_LOG_NAME, null, null));
        return mav;
    }

    //TODO make it so that server would accept only DTO object as it should be
    @PostMapping
    public TaskListDTO add(@Valid @RequestBody TaskList taskList) {
        return taskListService.add(taskList);
    }
}
