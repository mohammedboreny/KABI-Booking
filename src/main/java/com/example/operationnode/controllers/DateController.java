package com.example.operationnode.controllers;
import com.example.operationnode.entities.DateInterval;
import com.example.operationnode.operations.OperationsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class DateController {
    @Autowired
    OperationsDTO operations;

    @GetMapping("/getPriceSum")
    public ResponseEntity<Double>  getPriceSum(@RequestBody List<DateInterval> dateInterval){
        Double allSum=0.0;
        try{
            for (DateInterval interval : dateInterval) {
                allSum+=operations.calculatePrices(interval);
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
        try{
        for (DateInterval interval : dateInterval) {
            operations.postIntervalPrices(interval);
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
