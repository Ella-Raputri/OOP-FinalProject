/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

/**
 *
 * @author Asus
 */
public class CalendarToday {
    //attributes
    private int day;
    private int month;
    private int year;

    //constructor
    public CalendarToday(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
    //see whether the day, month, and year is the same as the one represented in CalendarToday or not
    public boolean isToday(CalendarToday date){
        return day == date.getDay() && month == date.getMonth() && year == date.getYear();
    }

    //getters and setters
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
}
