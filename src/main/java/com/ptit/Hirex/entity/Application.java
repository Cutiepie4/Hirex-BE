package com.ptit.Hirex.entity;

import java.util.*;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "application")
public class Application extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "attachment", columnDefinition = "TEXT")
    private String attachment;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "application", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ApplicationWork> applicationWorks = new ArrayList<>();

}
