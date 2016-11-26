/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafargeholcim.planb.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Calendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author AI-Saac
 */
public class Time {
    private static final String EPOCH_DATE = "1899-12-31";
    private static final int SECONDS_PER_DAY = 86400;
    private static final int SECONDS_PER_HOUR = 3600;
    private static DateTimeFormatter formatter = 
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    public static LocalDateTime nowDateTime(){
        return LocalDateTime.now();
    }
    
    public static LocalDate nowDate(){
        return LocalDate.now();
    }
    
    public static String getNow(){
        LocalDateTime dateTime = LocalDateTime.now();
        String date = dateTime.toLocalDate().toString();
        String time = dateTime.toLocalTime().toString();
        
        return date+" "+time.substring(0, 8);
    }
    
    public static String getEpochDate() {
        return EPOCH_DATE;
    }

    public static DateTimeFormatter getFormatter() {
        return formatter;
    }
    
    public static int getDaysBetweenDates(String start, String end){
        return (int)ChronoUnit.DAYS.between(parseDate(start), parseDate(end));
    }
    
    public static LocalDate parseDate(String date){
        if(date != null)
            return LocalDate.parse(date);
        return null;
    }
    
    public static LocalDateTime parseDateTime(String dateTime){
        if(dateTime != null)
            return LocalDateTime.parse(dateTime, formatter);
        return null;
    }
    
    public static LocalTime parseTime(String time){
        return LocalTime.parse(time);
    }
    
    public static Double getSerialNumberDate(String dateTime, boolean isDateTime){
        Double serialNumber = (double)0;
        Double fractionOfDay;
        int seconds = 0;
        
        if(isDateTime){
           LocalDateTime date = parseDateTime(dateTime);
           LocalTime time = date.toLocalTime();
           serialNumber = (double)getDaysBetweenDates(EPOCH_DATE, date.toLocalDate().toString());
           seconds += time.getHour() * SECONDS_PER_HOUR;
           seconds += time.getMinute() * 60;
           seconds += time.getSecond();
           fractionOfDay = (double)seconds / SECONDS_PER_DAY;
           serialNumber += fractionOfDay;
           return serialNumber+1;
        }
        else
           serialNumber = (double)getDaysBetweenDates(EPOCH_DATE, dateTime)+1;
        return serialNumber;
    }
    
    public static String getDate(Calendar calendar){
        int day, month, year;
        String date;
        
        day = calendar.get(Calendar.DAY_OF_MONTH);
        month = calendar.get(Calendar.MONTH) + 1;
        year = calendar.get(Calendar.YEAR);
        
        if(month > 9)
            if(day > 9)
                date = year+"-"+month+"-"+day;
            else
                date = year+"-"+month+"-"+0+day;
        else{
            if(day > 9)
                date = year+"-"+0+month+"-"+day;
            else
                date = year+"-"+0+month+"-"+0+day;
        }
        
        return date;
    }

    public boolean isThisDateValid(String dateToValidate, String dateFromat){

        if(dateToValidate == null)
            return false;

        SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
        sdf.setLenient(false);

        try {

            //if not valid, it will throw ParseException
            Date date = sdf.parse(dateToValidate);

        } catch (ParseException e) {

                e.printStackTrace();
                return false;
        }

        return true;
	}


}
