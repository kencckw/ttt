package com.payment.gateway.entity;

import com.payment.gateway.entity.common.BaseEntity;
import com.payment.gateway.entity.common.DataPayload;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class WorkflowExecution extends BaseEntity {

  @AttributeOverrides({
      @AttributeOverride(name = "storage", column = @Column(name = "input_storage")),
      @AttributeOverride(name = "data", column = @Column(name = "input_data")),
  })
  private DataPayload input;

  @AttributeOverrides({
      @AttributeOverride(name = "storage", column = @Column(name = "output_storage")),
      @AttributeOverride(name = "data", column = @Column(name = "output_data")),
  })
  private DataPayload output;
}
