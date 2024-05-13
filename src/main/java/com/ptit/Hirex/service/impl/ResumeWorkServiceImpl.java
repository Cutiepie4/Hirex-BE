package com.ptit.Hirex.service.impl;

import java.util.*;

import org.springframework.stereotype.Service;

import com.google.firebase.messaging.FirebaseMessagingException;
import com.ptit.Hirex.dtos.*;
import com.ptit.Hirex.entity.*;
import com.ptit.Hirex.exceptions.*;
import com.ptit.Hirex.repository.*;
import com.ptit.Hirex.request.PnsRequest;
import com.ptit.Hirex.service.*;
import com.ptit.Hirex.util.PnsRequestType;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ResumeWorkServiceImpl implements ResumeWorkService {

    private final ResumeWorkRepository resumeWorkRepository;
    private final WorkRepository workRepository;
    private final WorkService workService;
    private final ResumeService resumeService;
    private final NotificationReceiverService notificationReceiverService;
    private final FCMService fcmService;

    @Override
    public boolean hasDuplicateResume(ResumeWork resumeWork) {
        return resumeWorkRepository.existsByResumeAndWork(resumeWork.getResume(), resumeWork.getWork());
    }

    @Override
    public ResumeWork applyWork(ResumeWorkRequest resumeWorkRequest) {
        Resume resume = resumeService.validateAndGetResumeById(resumeWorkRequest.getResumeId());
        Work work = workService.validateAndGetWorkById(resumeWorkRequest.getWorkId());
        ResumeWork resumeWork = new ResumeWork(resume, work, resumeWorkRequest.getInformation());
        if (hasDuplicateResume(resumeWork)) {
            throw new DuplicatedEntityException("trùng cmm rồi");
        }
        return resumeWorkRepository.save(resumeWork);
    }

    private void pushNotification(ResumeWork result, String title, String content) {
        List<String> companyDetail = Arrays.asList(result.getWork().getCompany().getName(),
                result.getWork().getCompany().getDescription(),
                String.valueOf(result.getWork().getCompany().getEmployeeSize()));

        List<String> jobDetail = Arrays.asList(result.getWork().getName(), result.getWork().getDescription());
        NotificationRequest notificationRequest = new NotificationRequest(
                Arrays.asList(result.getResume().getEmployee().getUser().getPhoneNumber()),
                title,
                content,
                companyDetail,
                jobDetail);
        notificationReceiverService.saveNotifications(notificationRequest);
        try {
            fcmService.pushNotification(new PnsRequest(
                    PnsRequestType.INFO,
                    result.getResume().getEmployee().getUser().getPhoneNumber(),
                    title,
                    content));
        } catch (FirebaseMessagingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ResumeWork decideStatus(ResumeWorkStatusRequest resumeWorkRequest) {
        ResumeWork resumeWork = validateAndGetResumeWorkById(resumeWorkRequest.getId());
        if (resumeWork.getStatus().equals(ResumeStatus.PENDING)) {
            resumeWork.setStatus(resumeWorkRequest.getStatus());
            ResumeWork result = resumeWorkRepository.save(resumeWork);
            if (result.getStatus().equals(ResumeStatus.ACCEPTED)) {
                Work work = resumeWork.getWork();
                work.getEmployees().add(resumeWork.getResume().getEmployee());
                workRepository.save(work);
                String title = "Đã có kết quả ứng tuyển";
                String content = String.format(
                        "Đơn xin việc của bạn cho công ty %s đã được chấp thuận. Vui lòng liên hệ nhà tuyển dụng để biết thêm thông tin chi tiết",
                        result.getWork().getCompany().getName());
                pushNotification(result, title, content);
            } else if (result.getStatus().equals(ResumeStatus.REJECTED)) {
                String title = "Đã có kết quả ứng tuyển";
                String content = String.format(
                        "Đơn xin việc của bạn cho công ty %s đã bị từ chối. Vui lòng liên hệ nhà tuyển dụng để biết thêm thông tin chi tiết",
                        result.getWork().getCompany().getName());
                pushNotification(result, title, content);
            } else {
                // HANDLE ERROR
            }
        }
        return null;
    }

    @Override
    public Optional<ResumeWork> getResumeWorkById(Long id) {
        return resumeWorkRepository.findById(id);
    }

    @Override
    public ResumeWork validateAndGetResumeWorkById(Long id) {
        return getResumeWorkById(id)
                .orElseThrow(() -> new EntityNotFoundException("khong tim thay"));
    }

    @Override
    public List<ResumeWork> getResumeWorksByWorkId(int workId) {
        return resumeWorkRepository.findAllByWorkIdOrderByCreatedAtDesc(workId);
    }

}
