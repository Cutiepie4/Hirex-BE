package com.ptit.Hirex.service;

import java.util.*;

import com.ptit.Hirex.dtos.*;
import com.ptit.Hirex.entity.Appreciation;


public interface AppreciationService {

	Appreciation saveAppreciation(AppreciationRequest appreciationRequest);

	Optional<Appreciation> getAppreciationById(Long id);
	
	Appreciation validateAndGetAppreciationById(Long id);


}
