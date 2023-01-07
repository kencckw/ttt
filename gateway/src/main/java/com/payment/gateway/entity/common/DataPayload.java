package com.payment.gateway.entity.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.SneakyThrows;
import lombok.experimental.Accessors;

import javax.persistence.Embeddable;

@Data
@Embeddable
@Accessors(chain = true)
public class DataPayload {
  protected String storage;
  protected String data;

}
