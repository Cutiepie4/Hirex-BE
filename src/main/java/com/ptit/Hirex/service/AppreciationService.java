package com.ptit.Hirex.service;

import java.util.*;

import com.ptit.Hirex.dtos.*;
import com.ptit.Hirex.entity.Appreciation;
import com.ptit.Hirex.entity.Employee;
import com.ptit.Hirex.entity.Work;


public interface AppreciationService {

	Appreciation saveAppreciation(AppreciationRequest appreciationRequest);

	Appreciation getAppreciationByEmployeeAndWork(Employee employee, Work work);

}
