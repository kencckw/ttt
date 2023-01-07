package com.payment.gateway.tasks;

import com.payment.gateway.entity.enums.TaskStatus;
import com.payment.gateway.model.Task;

public abstract class TaskHandler {

  public boolean shouldHandle(Task task) {
    return task.getType().equals(this.getClass().getSimpleName());
  }

  public abstract TaskStatus handle(Task task);
}
