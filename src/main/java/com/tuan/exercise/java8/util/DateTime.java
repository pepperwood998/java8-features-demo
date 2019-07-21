package com.tuan.exercise.java8.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;

public class DateTime {
    private static Random rnd = new Random();
    private static int availYearDuration = 100;
    
    private DateTime() {
    }
    
    public static LocalDate getRandomDate() {
        int currentYear = LocalDate.now().getYear();
        int maxDayOfCurrentYear = LocalDate.now().getDayOfYear();
        
        return getRandomDate(currentYear - availYearDuration, currentYear, 1, maxDayOfCurrentYear);
    }
    
    public static LocalDate getRandomDate(int minYear, int maxYear, int minDayOfYear, int maxDayOfYear) {
        int year = rnd.nextInt(maxYear - minYear + 1) + minYear;
        int dayOfYear = rnd.nextInt(maxDayOfYear - minDayOfYear + 1) + minDayOfYear;
        
        return LocalDate.ofYearDay(year, dayOfYear);
    }
    
    public static LocalTime getRandomHour() {
        return getRandomHour(0, 23);
    }
    
    public static LocalTime getRandomHour(int minHour, int maxHour) {
        return LocalTime.of(rnd.nextInt(maxHour - minHour + 1) + minHour, 0);
    }
    
    public static LocalDateTime getRandomDateTime() {
        return LocalDateTime.of(getRandomDate(), getRandomHour());
    }
}
