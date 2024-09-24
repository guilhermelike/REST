package com.car.dto;

import com.car.domain.Passenger;
import lombok.Data;

@Data
public class TravelRequestInput {
    Long passengerId;
    String origin;
    String destination;
}
