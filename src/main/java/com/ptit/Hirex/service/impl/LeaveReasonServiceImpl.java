package com.ptit.Hirex.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ptit.Hirex.dtos.LeaveReasonDTO;
import com.ptit.Hirex.entity.Items;
import com.ptit.Hirex.entity.LeaveReason;
import com.ptit.Hirex.repository.ItemsRepository;
import com.ptit.Hirex.repository.LeaveReasonRepository;
import com.ptit.Hirex.service.LeaveReasonService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class LeaveReasonServiceImpl implements LeaveReasonService {
    private final LeaveReasonRepository leaveReasonRepository;
    private final ItemsRepository itemsRepository;

    @Override
    public LeaveReason createLeaveReason(LeaveReasonDTO leaveReasonDTO) throws Exception {
        LeaveReason leaveReason = new LeaveReason();
        Items item = itemsRepository.findById(leaveReasonDTO.getItemId())
                .orElseThrow(() -> new Exception("Không tìm thấy Item"));
        leaveReason.setItems(item);
        leaveReason.setReason(leaveReasonDTO.getLeaveReason());
        return leaveReasonRepository.save(leaveReason);
    }

    @Override
    public List<LeaveReason> getLeaveReasonsByItem(int id) throws Exception {
        return leaveReasonRepository.findByItems(itemsRepository.findById(id).orElseThrow(() -> new Exception("Lỗi, không lấy được lý do")));
    }

    @Override
    public boolean checkExistReason(int itemId) throws Exception {
        Optional<Items> itemOptional = itemsRepository.findById(itemId);
        if (itemOptional.isPresent()) {
            return true;
        }
        return false;
    }

    @Override
    public LeaveReason acceptReason(int reasonId) throws Exception {
        LeaveReason leaveReason = leaveReasonRepository.findById(reasonId).orElseThrow(
                () -> new Exception("Lỗi:" + reasonId));

        leaveReason.setIsAccept(true);
        return leaveReasonRepository.save(leaveReason);
    }

    @Override
    public LeaveReason rejectReason(int reasonId) throws Exception {
        System.out.println("hihihihi");
        LeaveReason leaveReason = leaveReasonRepository.findById(reasonId).orElseThrow(
                () -> new Exception("Lỗi: "+reasonId));
        leaveReason.setIsAccept(false);
        return leaveReasonRepository.save(leaveReason);
    }

    @Override
    public int countReason(int itemId) {
        return leaveReasonRepository.countByItemIdAndIsAcceptIsNull(itemId);
    }
}
