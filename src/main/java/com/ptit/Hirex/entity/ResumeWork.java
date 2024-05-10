package com.ptit.Hirex.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "application_work")
public class ResumeWork extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ResumeStatus status;
    
    private String information;

    @ManyToOne
    @JoinColumn(name = "resume_id", referencedColumnName = "id")
    private Resume resume;

    @ManyToOne
    @JoinColumn(name = "work_id", referencedColumnName = "id")
    private Work work;

    @PrePersist
    public void onPrePersist() {
        status = ResumeStatus.PENDING;
    }

    public ResumeWork(Resume resume, Work work, String information) {
        this.resume = resume;
        this.work = work;
        this.information = information;
    }
    
}
