package com.payment.gateway.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.payment.gateway.AbstractUnitTest;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class ParameterComparatorTest extends AbstractUnitTest {

  @Spy
  ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

  @Spy
  JsonUtils jsonUtils = new JsonUtils();

  @InjectMocks
  ParameterComparator comparator;


  @Test
  @SneakyThrows
  void test() {
    JsonNode params = mapper.readTree(new File("src/test/resources/params.yml"));
    JsonNode input = mapper.readTree(new File("src/test/resources/values.yml"));

    boolean evaluate = comparator.evaluate(params, input);
    System.out.println(evaluate);
  }
}
