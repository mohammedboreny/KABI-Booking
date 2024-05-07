package com.example.operationnode.operations;

import com.example.operationnode.entities.DateInterval;
import org.springframework.stereotype.Component;

@Component
public interface OperationsDTO {
    Double getIntervalSum(DateInterval date);
    boolean postIntervalSum(DateInterval date);
}
