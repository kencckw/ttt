package com.payment.gateway.entity;

import com.payment.gateway.entity.common.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@Entity
@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class Transaction extends BaseEntity {

  private String accountId;

  private String channelTransactionId;

  private String networkTransactionId;

  private String type;

  private String data;

  private String workflowExecutionId;

}
