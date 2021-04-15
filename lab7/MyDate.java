public class MyDate {
    private int day;
    private int month;
    private int year;
    int[] maxDays = {31,29,31,30,31,30,31,31,30,31,30,31};

    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month-1;
        this.year = year;
    }

    public void incrementDay() {

        int newDay = day+1;
        int maxDay = maxDays[month];
        if(newDay > maxDay){
            incrementMonth();
            day = 1 ;
        }
        else if(month == 1 && newDay== 29 && !leapYear()){
            day = 1;
            incrementMonth();
        }
        else{
            day = newDay;
        }
    }

    private boolean leapYear() {
        return year % 4 ==0 ? true : false;

    }

    public void incrementYear(int diff) {
        year += diff;
        if(month == 1 && day== 29 && !leapYear()){
            day=28;
        }
    }

    public void decrementDay() {
        int newDay = day-1;
        if(newDay==0){
            day=31;
            decrementMonth();
        }
        else{
            day=newDay;
        }
    }

    public void decrementYear() {
        incrementYear(-1);
    }

    public void decrementMonth() {
        incrementMonth(-1);
    }

    public void incrementDay(int diff) {
        while (diff > 0){
            incrementDay();
            diff--;
        }
    }

    public void decrementMonth(int month) {
        incrementMonth(-month);
    }

    public void decrementDay(int diff) {
        while (diff > 0) {
            decrementDay();
            diff--;
        }

    }

    public void incrementMonth(int diff) {
        int newMonth = (month + diff) % 12;
        int yearDiff=0;

        if(newMonth<0){
            newMonth +=12;
            yearDiff = -1;
        }
        yearDiff += (month + diff) / 12;
        month = newMonth;
        year += yearDiff;

        if (day > maxDays[month]){
            day = maxDays[month];
            if(month == 1 && day== 29 && !leapYear()){
                day=28;
            }
        }
    }

    public void decrementYear(int year) {
        incrementYear(-year);
    }

    public void incrementMonth() {
        incrementMonth(1);
    }

    public void incrementYear() {
        incrementYear(1);
    }

    public boolean isBefore(MyDate anotherDate) {
        int a = Integer.parseInt(toString().replaceAll("-", "")) ;
        int b = Integer.parseInt(anotherDate.toString().replaceAll("-", ""));
        return a < b;
    }

    public boolean isAfter(MyDate anotherDate) {
        int a = Integer.parseInt(toString().replaceAll("-", "")) ;
        int b = Integer.parseInt(anotherDate.toString().replaceAll("-", ""));
        return a > b;

    }
    public int dayDifference(MyDate anotherDate) {
        int diff = 0;
        if (isBefore(anotherDate)){
            MyDate date = new MyDate(day,month+1,year);
            while (date.isBefore(anotherDate)){
                date.incrementDay();
                diff++;
            }
        }
        else if(isAfter(anotherDate)){
            MyDate date = new MyDate(day,month+1,year);
            while (date.isAfter(anotherDate)){
                date.decrementDay();
                diff++;
            }
        }
        return diff;
    }

    public String toString(){
        return year + "-" + ((month+1) < 10 ? "0" : "") +(month+1)+ "-" + (day < 10 ? "0" : "") + day;
    }
}
