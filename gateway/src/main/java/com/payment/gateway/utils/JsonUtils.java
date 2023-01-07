package com.payment.gateway.utils;

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Component
public class JsonUtils {

  @Autowired
  ObjectMapper objectMapper;

  public static String encodeSegment(String segment) {
    final StringBuilder sb = new StringBuilder(segment.length() + 1);
    sb.append('/');
    for (int i = 0, end = segment.length(); i < end; ++i) {
      final char c = segment.charAt(i);
      if (c == '/') {
        sb.append("~1");
        continue;
      }
      if (c == '~') {
        sb.append("~0");
        continue;
      }
      sb.append(c);
    }
    return sb.toString();
  }

  public String decodeSegment(String segment) {
    return segment.replaceAll("~1", "/")
        .replaceAll("~0", "~");
  }

  public List<JsonPointer> getAllPointers(JsonNode jsonNode) {
    JsonNodeType nodeType = jsonNode.getNodeType();
    nodeType.equals(JsonNodeType.ARRAY);
    List<JsonPointer> pointers = new LinkedList<>();
    getAllPointers(pointers, JsonPointer.empty(), jsonNode);
    return pointers;
  }

  protected void getAllPointers(List<JsonPointer> pointers, JsonPointer currentPath, JsonNode jsonNode) {
    if (jsonNode.isArray()) {
      for (int i = 0; i < jsonNode.size(); i++) {
        getAllPointers(pointers, currentPath.append(JsonPointer.valueOf(encodeSegment(i + ""))), jsonNode.get(i));
      }
    } else if (jsonNode.isObject()) {
      Iterator<String> fieldNames = jsonNode.fieldNames();
      while (fieldNames.hasNext()) {
        String fieldName = fieldNames.next();
        getAllPointers(pointers, currentPath.append(JsonPointer.valueOf(encodeSegment(fieldName))), jsonNode.get(fieldName));
      }
    } else {
      pointers.add(currentPath);
    }
  }

  @SneakyThrows
  protected JsonNode read(File data) {
    return objectMapper.readTree(data);
  }

  @SneakyThrows
  protected JsonNode read(String data) {
    return objectMapper.readTree(data);
  }
}
