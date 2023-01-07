package com.payment.gateway.model;

import lombok.Data;

import java.util.Map;

@Data
public class Task {

  /**
   * Task Type handler
   */
  private String type;

  /**
   * Execution Order
   */
  private Long order;

  private Map<String, Object> input;
  private Map<String, Object> output;
}
