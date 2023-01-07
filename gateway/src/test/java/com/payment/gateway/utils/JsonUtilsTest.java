package com.payment.gateway.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.payment.gateway.AbstractUnitTest;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class JsonUtilsTest extends AbstractUnitTest {

  @Spy
  ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

  @InjectMocks
  JsonUtils jsonUtils;

  @Test
  @SneakyThrows
  void test() {
//    JsonNode jsonNode = mapper.readTree(new File("src/test/resources/test.yml"));
//    List<String> allPointers = jsonUtils.getAllPointers(jsonNode);
//    System.out.println(allPointers);
//
//    allPointers.forEach(p -> {
//      System.out.println(jsonNode.at(p));
//    });
  }
}
