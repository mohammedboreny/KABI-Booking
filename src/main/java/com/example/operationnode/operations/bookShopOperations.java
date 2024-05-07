package com.example.operationnode.operations;

import com.example.operationnode.entities.DateInterval;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Objects;


@Component
public class bookShopOperations implements OperationsDTO {

    HashMap<LocalDate,Double> dateHashMap = new HashMap<>();

    @Override
    public Double getIntervalSum(DateInterval intervalWithPrice) {
        LocalDate currentDate = intervalWithPrice.getStartDate();
        double startDateValue = dateHashMap.get(currentDate);
        double sum=0;
        while (!currentDate.isAfter(intervalWithPrice.getEndDate())){
            sum += dateHashMap.get(currentDate)==startDateValue&&dateHashMap.get(currentDate)!=null?dateHashMap.get(currentDate):0;
            currentDate = currentDate.plusDays(1);
        }
        return sum;
    }

    @Override
    public boolean postIntervalSum(DateInterval date) {
        if (date==null)
            return false;
        LocalDate currentDate = date.getStartDate();
        while (!currentDate.isAfter(date.getEndDate())) {
            dateHashMap.put(currentDate, date.getPrice());
            currentDate = currentDate.plusDays(1);
        }
        return true;
    }
}
