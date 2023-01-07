package com.payment.gateway.utils;

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@Component
public class ParameterComparator {

  @Autowired
  JsonUtils jsonUtils;

  private enum OperationType {
    NE,
    EQ,
    IN
  }


  protected boolean compare(OperationType type, JsonNode params, JsonNode input) {
    if (type.equals(OperationType.EQ)) {
      return params.equals(input);
    } else if (type.equals(OperationType.NE)) {
      return !params.equals(input);
    } else if (type.equals(OperationType.IN)) {
      for (JsonNode param : params) {
        if (param.equals(input)) {
          return true;
        }
      }
      return false;
    }
    throw new RuntimeException();
  }

  public boolean evaluate(JsonNode params, JsonNode input) {
    Iterator<String> fieldNames = params.fieldNames();
    while(fieldNames.hasNext()) {
      String fieldName = fieldNames.next();
      JsonNode jsonNode = params.get(fieldName);
      JsonNode inputValue = input.at(fieldName);
      OperationType operationType;
      JsonNode paramValue;
      if (jsonNode.isObject()) {
        Iterator<String> operations = jsonNode.fieldNames();
        while (operations.hasNext()) {
          String operation = operations.next();
          operationType = OperationType.valueOf(operation.toUpperCase());
          paramValue = jsonNode.get(operation);
          if (!this.compare(operationType, paramValue, inputValue)) {
            return false;
          }
        }
      } else {
        paramValue = jsonNode;
        operationType = OperationType.EQ;
        if (!this.compare(operationType, paramValue, inputValue)) {
          return false;
        }
      }
    }
    return true;
  }
}
