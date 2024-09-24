package com.car.domain;

import com.car.dto.TravelRequestStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class TravelRequest {
    @Id
    @GeneratedValue
    Long id;

    @ManyToOne
    Passenger passenger;
    String origin;
    String destination;

    @Enumerated(EnumType.STRING)
    TravelRequestStatus status;
    Date creationDate;
}
