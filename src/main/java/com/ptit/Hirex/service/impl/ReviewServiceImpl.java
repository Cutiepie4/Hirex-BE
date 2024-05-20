package com.ptit.Hirex.service.impl;

import java.util.*;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ptit.Hirex.dtos.*;
import com.ptit.Hirex.entity.*;
import com.ptit.Hirex.exceptions.*;
import com.ptit.Hirex.repository.*;
import com.ptit.Hirex.service.*;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {
    private final ModelMapper modelMapper;
    private final ReviewRepository reviewRepository;


    public Review createReview(ReviewRequest reviewRequest, User user) {
        Review review = modelMapper.map(reviewRequest, Review.class);
        review.setUser(user);
        Review result = reviewRepository.save(review);
        return result;
    }

    public ReviewDTO getMyReview(User user, Long companyId) {
        Review review = reviewRepository.findByUserIdAndCompanyId(user.getId(), companyId).orElseThrow(() -> new EntityNotFoundException("Bạn chưa đánh giá công ty này"));
        return modelMapper.map(review, ReviewDTO.class);
    }

}
