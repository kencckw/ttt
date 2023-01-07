package com.payment.gateway.service.impl;

import com.payment.gateway.entity.enums.TaskStatus;
import com.payment.gateway.tasks.TaskHandler;
import com.payment.gateway.model.Task;
import com.payment.gateway.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TaskServiceImpl implements TaskService {

  @Autowired
  List<TaskHandler> taskHandlers;

  void execute(Task task) {
    TaskHandler taskHandler = taskHandlers.stream().filter(t -> t.shouldHandle(task)).findFirst().orElseThrow(() -> new RuntimeException("not implemented"));

    TaskStatus taskStatus = taskHandler.handle(task);

    // TODO: update taskExecution status
    // TODO:

  }
}
