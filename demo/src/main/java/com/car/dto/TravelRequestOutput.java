package com.car.dto;

import com.car.domain.Passenger;
import lombok.Data;

import java.util.Date;

@Data
public class TravelRequestOutput {
    Long id;
    String origin;
    String destination;
    TravelRequestStatus status;
    Date creationDate;
}
