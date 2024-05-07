package com.example.operationnode.controllers;


import com.example.operationnode.entities.DateInterval;
import com.example.operationnode.operations.OperationsDTO;
import com.example.operationnode.operations.bookShopOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
//        startDate.getDayOfMonth(); days
//        startDate.getMonthValue(); month
//        startDate.getYear(); year

public class DateController {


    @Autowired
    OperationsDTO operations;

    public DateController( @Autowired OperationsDTO operations) {
        this.operations = new bookShopOperations();
    }

    @GetMapping("/getPriceSum")
    public ResponseEntity<Double>  getPriceSum(@RequestBody List<DateInterval> dateInterval){
        dateInterval.sort(Comparator.comparing(DateInterval::getStartDate));
        Double allSum=0.0;
        try{
            for (DateInterval interval : dateInterval) {
                allSum+=operations.getIntervalSum(interval);
            }
    return new ResponseEntity<>(
                allSum,
                HttpStatus.OK);
        }catch (Exception e){
    System.out.println(e.getMessage());
    return new ResponseEntity<>(
                    0.0,
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/setPrices")
    public ResponseEntity<String> setPrices(@RequestBody List<DateInterval> dateInterval) {
//        dateInterval.sort(Comparator.comparing(DateInterval::getStartDate));
        System.out.println(dateInterval);
        try{
        for (DateInterval interval : dateInterval) {
            operations.postIntervalSum(interval);
        }
        return new ResponseEntity<>(
                        "Successful",
                        HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(
                    "Something went wrong",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }}
}
