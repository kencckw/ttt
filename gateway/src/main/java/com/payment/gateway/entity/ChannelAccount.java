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
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class ChannelAccount extends BaseEntity {

  @Id
  private String id;

  private String channelCode;

  private DataPayload data;

  @Column(updatable = false)
  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;
}
