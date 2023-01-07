package com.payment.gateway.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Workflow {

  private List<Task> tasks;

  private Map<String, Object> input;
  private Map<String, Object> output;
}
