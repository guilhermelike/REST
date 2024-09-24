package com.car.services;

import com.car.domain.TravelRequest;
import com.car.domain.TravelRequestRepository;
import com.car.dto.TravelRequestStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TravelService{
    @Autowired
    TravelRequestRepository travelRequestRepository;

    public TravelRequest saveTravelRequest(TravelRequest travelRequest){
        travelRequest.setStatus(TravelRequestStatus.CREATED);
        travelRequest.setCreationDate(new Date());
        return travelRequestRepository.save(travelRequest);
    }
}

