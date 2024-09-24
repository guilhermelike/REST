package com.car.interfaces;

import com.car.domain.Passenger;
import com.car.domain.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RestController
@RequestMapping(path="/passengers", produces = MediaType.APPLICATION_JSON_VALUE)
public class PassengerAPI {
    @Autowired
    PassengerRepository passengerRepository;

    @GetMapping()
    public List<Passenger> listPassengers(){
        return passengerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Passenger findPassenger(@PathVariable("id") Long id){
        return passengerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public Passenger createPassenger(@RequestBody Passenger passenger){
        return passengerRepository.save(passenger);
    }

    @PutMapping("/{id}")
    public Passenger fullUpdatePassenger(@PathVariable("id") Long id, @RequestBody Passenger passenger){
        Passenger p = findPassenger(id);
        p.setName(passenger.getName());
        return passengerRepository.save(p);
    }

    @DeleteMapping("/{id}")
    public void deletePassenger(@PathVariable("id") Long id){
        passengerRepository.delete(findPassenger(id));
    }
}
