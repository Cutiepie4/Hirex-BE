package com.ptit.Hirex.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ptit.Hirex.dtos.ItemsDTO;
import com.ptit.Hirex.dtos.SchedulesDTO;
import com.ptit.Hirex.entity.Items;
import com.ptit.Hirex.entity.Schedule;
import com.ptit.Hirex.entity.User;
import com.ptit.Hirex.repository.ItemsRepository;
import com.ptit.Hirex.repository.ScheduleRepository;
import com.ptit.Hirex.repository.UserRepository;
import com.ptit.Hirex.responses.ScheduleResponse;
import com.ptit.Hirex.service.LeaveReasonService;
import com.ptit.Hirex.service.ScheduleService;

import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final ItemsRepository itemsRepository;
    private final UserRepository userRepository;
    private final LeaveReasonService leaveReasonService; 


    @Override
    public List<Schedule> getMarkDate(String phoneNumber){
        return userRepository.findByPhoneNumber(phoneNumber)
                .map(user -> scheduleRepository.findByUser(user))
                .orElse(Collections.emptyList());
    }

    @Override
    public List<ScheduleResponse> getSchedulesByUserId(String phoneNumber, LocalDate dateStart, LocalDate dateEnd) throws Exception {
        List<Schedule> listSchedule = userRepository.findByPhoneNumber(phoneNumber)
                .map(user -> scheduleRepository.findByUserAndDateBetween(user, dateStart, dateEnd))
                .orElse(Collections.emptyList());
        // System.out.println("1111111111111");
        List<ScheduleResponse> lResponses = new ArrayList<>();
        for(Schedule schedule: listSchedule){
            // System.out.println(schedule.getDate());
            ScheduleResponse scheduleResponse = new ScheduleResponse();
            scheduleResponse.setDate(schedule.getDate());
            List<ItemsDTO> lItemsDTOs = new ArrayList<>();
            for(Items item: schedule.getItems()){
                int totalReaon = 0;
                if(item.getType().equals("working")){
                    totalReaon = leaveReasonService.countReason(item.getWork().getId(), schedule.getDate());
                }
                Integer work_id = null;
                if(item.getWork()!=null){
                    work_id = item.getWork().getId();
                }
                ItemsDTO itemsDTO = new ItemsDTO(item.getStartTime(), item.getEndTime(), item.getTitle(), item.getType(), item.getNotes(), item.getNotification(), item.getType_notif(), work_id, item.getId(), totalReaon);
                lItemsDTOs.add(itemsDTO);
            }
            scheduleResponse.setItemsDTO(lItemsDTOs);
            lResponses.add(scheduleResponse);
        }
        // System.out.println(lResponses);
        return lResponses;
    }

    @Override
    public Items createSchedule(String phoneNumber, SchedulesDTO schedulesDTO) {
        validateScheduleDTO(schedulesDTO);
        User user = userRepository.findByPhoneNumber(phoneNumber).get();
        Schedule schedule = scheduleRepository.findByDateAndUser(schedulesDTO.getDate(), user);
        if (schedule == null) {
            schedule = new Schedule();
            schedule.setDate(schedulesDTO.getDate());
            schedule.setItems(new ArrayList<>());
            schedule.setUser(user);
            schedule = scheduleRepository.save(schedule);
        }
        Items item = new Items();
        item.setStartTime(schedulesDTO.getItemsDTO().getStartTime());
        item.setEndTime(schedulesDTO.getItemsDTO().getEndTime());
        item.setTitle(schedulesDTO.getItemsDTO().getTitle());
        item.setType(schedulesDTO.getItemsDTO().getType());
        item.setNotes(schedulesDTO.getItemsDTO().getNotes());
        item.setNotification(schedulesDTO.getItemsDTO().getNotification());
        item.setType_notif(schedulesDTO.getItemsDTO().getType_notif());
        validateItem(item);
        item.setSchedule(schedule);
        return itemsRepository.save(item);
    }

    @Override
    public Items updateSchedule(int id, SchedulesDTO schedulesDTO) {
        return itemsRepository.findById(id)
                .map(item -> updateItemFields(item, schedulesDTO.getItemsDTO()))
                .map(itemsRepository::save)
                .orElseThrow(() -> new NoSuchElementException("No item found with id: " + id));
    }

    private Items updateItemFields(Items item, ItemsDTO scheduleItemDetails) {
        item.setStartTime(scheduleItemDetails.getStartTime());
        item.setEndTime(scheduleItemDetails.getEndTime());
        item.setTitle(scheduleItemDetails.getTitle());
        item.setType(scheduleItemDetails.getType());
        item.setNotes(scheduleItemDetails.getNotes());
        item.setNotification(scheduleItemDetails.getNotification());
        item.setType_notif(scheduleItemDetails.getType_notif());
        return item;
    }

    @Override
    public boolean deleteSchedule(int id) {
        try {
            itemsRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }

    private void validateScheduleDTO(SchedulesDTO schedulesDTO) {
        if (schedulesDTO == null || schedulesDTO.getItemsDTO() == null) {
            throw new IllegalArgumentException("Schedule data cannot be null.");
        }
    }

    private void validateItem(Items item) {
        if (StringUtils.isBlank(item.getTitle()) || StringUtils.isBlank(item.getNotes())) {
            throw new IllegalArgumentException("Lỗi, không được để trống tiêu đề");
        }
        System.out.println(1);
        if (!(item.getType().equals("personal") || item.getType().equals("working"))) {
            throw new IllegalArgumentException("Loại sai định dạng");
        }
        System.out.println(2);
        if (item.getStartTime() == null || item.getEndTime() == null) {
            throw new IllegalArgumentException("Lỗi, không được để trống thời gian");
        }
        System.out.println(3);
        if (item.getStartTime().isAfter(item.getEndTime())) {
            throw new IllegalArgumentException("Lỗi, Thời gian bắt đầu không thể sau thời gian kết thúc");
        }
    }
}
