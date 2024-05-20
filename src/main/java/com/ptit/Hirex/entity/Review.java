package com.ptit.Hirex.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "review")
public class Review extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "title", columnDefinition = "TEXT")
    private String title;

    @Column(name = "what_you_like", columnDefinition = "TEXT")
    private String whatYouLike;

    @Column(name = "feedback", columnDefinition = "TEXT")
    private String feedback;

    private int overallRate;
    private int salaryRate;
    private int trainingRate;
    private int managementRate;
    private int cultureRate;
    private int officeRate;

    private boolean recommend;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

}
