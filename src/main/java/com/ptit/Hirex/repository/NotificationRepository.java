package com.ptit.Hirex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ptit.Hirex.entity.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
