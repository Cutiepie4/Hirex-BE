package com.ptit.Hirex.service.impl;

import com.ptit.Hirex.dtos.SchedulesDTO;
import com.ptit.Hirex.entity.Items;
import com.ptit.Hirex.entity.Schedule;
import com.ptit.Hirex.entity.User;
import com.ptit.Hirex.repository.ItemsRepository;
import com.ptit.Hirex.repository.ScheduleRepository;
import com.ptit.Hirex.repository.UserRepository;
import com.ptit.Hirex.service.ScheduleService;

import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final ItemsRepository itemsRepository;
    private final UserRepository userRepository;

    @Override
    public List<Schedule> getSchedulesByUserId(String phoneNumber) {
        return userRepository.findByPhoneNumber(phoneNumber)
                .map(user -> scheduleRepository.findByUser(user))
                .orElse(Collections.emptyList());
    }

    @Override
    public Schedule createSchedule(String phoneNumber ,SchedulesDTO schedulesDTO) {
        validateScheduleDTO(schedulesDTO);
        User user = userRepository.findByPhoneNumber(phoneNumber).get();
        Schedule schedule = scheduleRepository.findByDate(schedulesDTO.getDate());
        if (schedule == null) {
            schedule = new Schedule();
            schedule.setDate(schedulesDTO.getDate());
            schedule.setItems(new ArrayList<>());
            schedule.setUser(user);
            schedule = scheduleRepository.save(schedule);
        }
        Items item = schedulesDTO.getItems();
        validateItem(item);
        item.setSchedule(schedule);
        itemsRepository.save(item);

        return schedule;
    }

    @Override
    public Items updateSchedule(int id, SchedulesDTO schedulesDTO) {
        return itemsRepository.findById(id)
                .map(item -> updateItemFields(item, schedulesDTO.getItems()))
                .map(itemsRepository::save)
                .orElseThrow(() -> new NoSuchElementException("No item found with id: " + id));
    }

    private Items updateItemFields(Items item, Items scheduleItemDetails) {
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
        if (schedulesDTO == null || schedulesDTO.getItems() == null) {
            throw new IllegalArgumentException("Schedule data cannot be null.");
        }
    }

    private void validateItem(Items item) {
        if (StringUtils.isBlank(item.getTitle()) || StringUtils.isBlank(item.getNotes())) {
            throw new IllegalArgumentException("Lỗi, không được để trống tiêu đề");
        }
        System.out.println(1);
        if(!(item.getType().equals("personal") || item.getType().equals("working"))){
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
