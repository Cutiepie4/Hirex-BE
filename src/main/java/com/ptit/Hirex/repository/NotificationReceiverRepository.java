package com.ptit.Hirex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ptit.Hirex.entity.NotificationReceiver;

@Repository
public interface NotificationReceiverRepository extends JpaRepository<NotificationReceiver, Long> {
    List<NotificationReceiver> findAllByReceiverId(Long id);
}
