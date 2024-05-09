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
public class ApplicationWork extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ApplicationStatus status;
    private String information;

    @ManyToOne
    @JoinColumn(name = "application_id", referencedColumnName = "id")
    private Application application;

    @ManyToOne
    @JoinColumn(name = "work_id", referencedColumnName = "id")
    private Work work;

    @PrePersist
    public void onPrePersist() {
        status = ApplicationStatus.PENDING;
    }

    public ApplicationWork(Application application, Work work, String information) {
        this.application = application;
        this.work = work;
        this.information = information;
    }
    
}
