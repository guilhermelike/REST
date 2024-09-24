package com.car.interfaces;

import com.car.domain.TravelRequest;
import com.car.dto.TravelRequestOutput;
import com.car.services.TravelService;
import com.car.dto.TravelRequestInput;
import com.car.dto.TravelRequestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
@RestController
@RequestMapping(path = "/travelRequests", produces = MediaType.APPLICATION_JSON_VALUE)
public class TravelRequestAPI {
    @Autowired
    TravelService travelService;

    @Autowired
    TravelRequestMapper mapper;
    @PostMapping
    public EntityModel<TravelRequestOutput> makeTravelRequest(@RequestBody TravelRequestInput travelRequestInput){
        TravelRequest request = travelService.saveTravelRequest(mapper.map(travelRequestInput));
        TravelRequestOutput output = mapper.map(request);
        return mapper.buildOutputModel(request, output);
    }
}
