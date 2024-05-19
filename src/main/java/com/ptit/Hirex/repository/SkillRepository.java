package com.ptit.Hirex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ptit.Hirex.entity.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {

}
