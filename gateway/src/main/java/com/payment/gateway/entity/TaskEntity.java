package com.payment.gateway.entity;


import com.payment.gateway.entity.common.BaseEntity;
import com.payment.gateway.entity.common.DataPayload;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;


@Entity(name = "task")
@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class TaskEntity extends BaseEntity {

  @Id
  @GeneratedValue
  private Long id;

  private Long workflowId;

  private DataPayload data;

  @Column(updatable = false)
  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;
}
