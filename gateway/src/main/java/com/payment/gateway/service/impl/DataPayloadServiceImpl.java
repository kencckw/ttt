package com.payment.gateway.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.payment.gateway.entity.common.DataPayload;
import com.payment.gateway.service.DataPayloadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DataPayloadServiceImpl implements DataPayloadService {

  @Autowired
  protected ObjectMapper objectMapper;

  public <T> T load(DataPayload payload, Class<T> clazz) {
    return objectMapper.convertValue(payload.getData(), clazz); // TODO: only support raw atm
  }

}
