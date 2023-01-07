package com.payment.gateway.repository;

import com.payment.gateway.entity.TaskExecution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskExecutionRepository extends JpaRepository<TaskExecution, Long> {

}
