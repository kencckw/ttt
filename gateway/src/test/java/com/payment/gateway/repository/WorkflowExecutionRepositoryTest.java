package com.payment.gateway.repository;

import com.payment.gateway.AbstractIntegrationTest;
import com.payment.gateway.entity.WorkflowExecution;
import com.payment.gateway.entity.common.DataPayload;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class WorkflowExecutionRepositoryTest extends AbstractIntegrationTest {

  @Autowired
  private WorkflowExecutionRepository repository;

  @Test
  void test() {
    WorkflowExecution entity = WorkflowExecution.builder()
        .input(new DataPayload()
            .setData("a")
            .setStorage("raw"))
        .output(new DataPayload()
            .setData("b")
            .setStorage("raw"))
        .build();

    repository.save(entity);
  }

}
