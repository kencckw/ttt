package com.payment.gateway.entity;

import com.payment.gateway.entity.common.BaseEntity;
import com.payment.gateway.entity.enums.TaskStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class TaskExecution extends BaseEntity {

  @Id
  @GeneratedValue
  private Long id;

  private Long taskId;

  private String taskType;

  private String input;

  private String output;

  @Enumerated(EnumType.STRING)
  TaskStatus status;

  @Column(updatable = false)
  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;

}
