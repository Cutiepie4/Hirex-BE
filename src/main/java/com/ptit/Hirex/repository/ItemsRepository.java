package com.ptit.Hirex.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ptit.Hirex.entity.Items;

public interface ItemsRepository extends JpaRepository<Items, Integer> {
    
}
