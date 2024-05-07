package com.example.operationnode.entities;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

import java.util.Objects;


public class DateInterval {

    LocalDate startDate;
    LocalDate  endDate;
    Double Price;

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateInterval that = (DateInterval) o;
        return Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate) && Objects.equals(Price, that.Price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, endDate, Price);
    }

    @Override
    public String toString() {
        return "DateInterval{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", Price=" + Price +
                '}';
    }
}
