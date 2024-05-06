package com.ptit.Hirex.service;

import com.ptit.Hirex.dtos.CertificationDTO;


public interface CertificationService {
    void saveCertification(CertificationDTO certificationDTO);
    
    void updateCertification(Long certificationId, CertificationDTO certificationDTO);
    
    void deleteCertification(Long certificationId);
}
