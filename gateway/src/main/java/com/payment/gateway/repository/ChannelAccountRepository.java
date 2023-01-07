package com.payment.gateway.repository;

import com.payment.gateway.entity.ChannelAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChannelAccountRepository extends JpaRepository<ChannelAccount, Long> {

}
