package com.payment.gateway.entity;

import com.payment.gateway.entity.common.BaseEntity;
import com.payment.gateway.entity.common.DataPayload;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@Entity(name = "workflow")
@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class WorkflowEntity extends BaseEntity {

  private String type;

  private DataPayload data;


}
