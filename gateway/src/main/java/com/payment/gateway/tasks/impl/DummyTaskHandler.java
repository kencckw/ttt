package com.payment.gateway.tasks.impl;

import com.payment.gateway.entity.enums.TaskStatus;
import com.payment.gateway.model.Task;
import com.payment.gateway.tasks.TaskHandler;
import com.payment.gateway.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DummyTaskHandler extends TaskHandler {

  @Autowired
  JsonUtils jsonUtils;

  @Override
  public TaskStatus handle(Task task) {
    return TaskStatus.SUCCESS;
  }
}
