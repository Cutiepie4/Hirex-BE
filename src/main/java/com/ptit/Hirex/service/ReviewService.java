package com.ptit.Hirex.service;

import java.util.*;

import com.ptit.Hirex.dtos.*;
import com.ptit.Hirex.entity.*;


public interface ReviewService {
    Review createReview(ReviewRequest reviewRequest, User user);
    ReviewDTO getMyReview(User user, Long companyId);

}
