package com.ptit.Hirex.service.impl;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

import org.springframework.stereotype.Service;

import com.ptit.Hirex.dtos.*;
import com.ptit.Hirex.entity.*;
import com.ptit.Hirex.exceptions.*;
import com.ptit.Hirex.repository.*;
import com.ptit.Hirex.service.*;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ResumeWorkServiceImpl implements ResumeWorkService {

    private final ResumeWorkRepository resumeWorkRepository;
    private final ScheduleRepository scheduleRepository;
    private final ItemsRepository itemsRepository;
    private final WorkRepository workRepository;
    private final WorkService workService;
    private final ResumeService resumeService;

    @Override
    public boolean hasDuplicateResume(ResumeWork resumeWork) {
        return false;
        // return resumeWorkRepository.existsByUserAndWorkAndStatus(resume.getUser(), resume.getWork(), "new")
        //     || resumeWorkRepository.existsByUserAndWorkAndStatus(resume.getUser(), resume.getWork(), "applied");
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
    @Override
    public ResumeWork decideStatus(ResumeWorkStatusRequest resumeWorkRequest) {
        ResumeWork resumeWork = validateAndGetResumeWorkById(resumeWorkRequest.getId());
        if (resumeWork.getStatus().equals(ResumeStatus.PENDING)) {
            resumeWork.setStatus(resumeWorkRequest.getStatus());
            ResumeWork result = resumeWorkRepository.save(resumeWork);
            if (result.getStatus().equals(ResumeStatus.ACCEPTED)) {
                User userEmployee = resumeWork.getResume().getEmployee().getUser();
                User userEmployer = resumeWork.getWork().getCompany().getEmployer().getUser();
                Work work = resumeWork.getWork();
                LocalDate startDate = work.getStartDate();
                LocalDate endDate = work.getEndDate();

                LocalDate currentDate = startDate;
                while (!currentDate.isAfter(endDate)) {
                    System.out.println(currentDate);

                    // Kiểm tra và lấy Schedule cho Employee
                    Schedule optScheduleEmployee = scheduleRepository.findByDateAndUser(currentDate, userEmployee);
                    if (optScheduleEmployee == null) {
                        Schedule newSchedule = new Schedule();
                        newSchedule.setDate(currentDate);
                        newSchedule.setItems(new ArrayList<>());
                        newSchedule.setUser(userEmployee);
                        optScheduleEmployee = scheduleRepository.save(newSchedule);
                    };

                    // Tạo và lưu Item cho Employee
                    Items itemEmployee = createAndSaveItem(work, currentDate, "working");
                    itemEmployee.setSchedule(optScheduleEmployee);
                    itemsRepository.save(itemEmployee);

                    // Kiểm tra và lấy Schedule cho Employer
                    Schedule optScheduleEmployer = scheduleRepository.findByDateAndUser(currentDate, userEmployer);
                    if (optScheduleEmployer == null) {
                        Schedule newSchedule = new Schedule();
                        newSchedule.setDate(currentDate);
                        newSchedule.setItems(new ArrayList<>());
                        newSchedule.setUser(userEmployer);
                        optScheduleEmployer =  scheduleRepository.save(newSchedule);
                    };

                    // Kiểm tra xem Item đã tồn tại cho Work và Schedule chưa
                    boolean check = itemsRepository.existsByWorkAndSchedule(work, optScheduleEmployer);
                    if (!check) {
                        // Tạo và lưu Item cho Employer nếu chưa tồn tại
                        Items itemEmployer = createAndSaveItem(work, currentDate, "working");
                        itemEmployer.setSchedule(optScheduleEmployer);
                        itemsRepository.save(itemEmployer);
                    }

                    currentDate = currentDate.plusDays(1);
                }
                work.getEmployees().add(resumeWork.getResume().getEmployee());
                workRepository.save(work);
            } else if (result.getStatus().equals(ResumeStatus.REJECTED)) {
                // NOTHING TO DO
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
    
    public Items createAndSaveItem(Work work, LocalDate currentDate, String type) {
        Items item = new Items();
        item.setStartTime(work.getStartTime());
        item.setEndTime(work.getEndTime());
        item.setTitle("Công việc tại " + work.getCompany().getName());
        item.setNotes("Làm việc");
        LocalDateTime notificationDateTime = LocalDateTime.of(currentDate, work.getStartTime());
        item.setNotification(notificationDateTime);
        item.setType_notif("Vào lúc diễn ra sự kiện");
        item.setType(type);
        item.setWork(work);
        return itemsRepository.save(item);
    }
}
