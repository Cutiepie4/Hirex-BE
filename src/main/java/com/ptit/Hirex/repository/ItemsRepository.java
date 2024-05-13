package com.ptit.Hirex.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ptit.Hirex.entity.Items;
import java.time.LocalDateTime;


public interface ItemsRepository extends JpaRepository<Items, Integer> {
    List<Items> findByNotificationBetween(LocalDateTime start, LocalDateTime end);
}
