package com.payment.gateway.service.impl;

import com.payment.gateway.entity.WorkflowEntity;
import com.payment.gateway.model.Task;
import com.payment.gateway.model.Workflow;
import com.payment.gateway.service.TaskService;
import com.payment.gateway.service.WorkflowService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class WorkflowServiceImpl implements WorkflowService {

  @Autowired
  protected DataPayloadServiceImpl dataPayloadService;

  @Autowired
  protected TaskServiceImpl taskService;

  public void execute(Workflow workflow) {
    List<Task> tasks = workflow.getTasks();

    for (Task task : tasks) {
      taskService.execute(task);
    }

  }



}
