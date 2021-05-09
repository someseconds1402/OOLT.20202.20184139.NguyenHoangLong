package Date;

import java.util.Random;

public class DateUtils {

    private static final int MAX_NUMBER_DATES = 50;
    private int countDates;
    private MyDate[] dateList = new MyDate[MAX_NUMBER_DATES];

    public int getCountDates() {
        return countDates;
    }

    public DateUtils() {
        countDates = 0;
    }

    // date1 > date2 => return 1
    // date1 < date2 => return -1
    // date1 = date2 => return 0
    public int compareTwoDates(MyDate date1, MyDate date2) {
        if (date1.getYear() < date2.getYear()) {
            return -1;
        } else if (date1.getYear() > date2.getYear()) {
            return 1;
        } else {
            if (date1.getMonth() < date2.getMonth()) {
                return -1;
            } else if (date1.getMonth() > date2.getMonth()) {
                return 1;
            } else {
                if (date1.getDay() < date2.getDay()) {
                    return -1;
                } else if (date1.getDay() > date2.getDay()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }

    // Sắp xếp ngày tháng thứ tự giảm dần
    public void sortDateList() {
        int tmpDay, tmpMonth, tmpYear;
        int i, j;
        if (countDates > 0) {
            for (i = 0; i < countDates - 1; i++) {
                for (j = i; j < countDates; j++) {
                    if (compareTwoDates(dateList[i], dateList[j]) == -1) {
                        tmpYear = dateList[i].getYear();
                        tmpMonth = dateList[i].getMonth();
                        tmpDay = dateList[i].getDay();

                        dateList[i].setYear(dateList[j].getYear());
                        dateList[i].setMonth(dateList[j].getMonth());
                        dateList[i].setDay(dateList[j].getDay());

                        dateList[j].setYear(tmpYear);
                        dateList[j].setMonth(tmpMonth);
                        dateList[j].setDay(tmpDay);
                    }
                }
            }
        }
    }

    public boolean addDate(MyDate date) {
        if (countDates >= MAX_NUMBER_DATES) {
            System.out.println("The dateList is almost full!");
            return false;
        } else {
            dateList[countDates++] = date;
            System.out.println("Add date successfully!");
            return true;
        }
    }

    public void addDate(MyDate... list) {
        if (list != null && list.length > 0) {
            for (MyDate datePara : list) {
                if (!addDate(datePara)) {
                    System.out.println("Error! Full Ordered Items!");
                    return;
                }
            }
        } else {
            System.out.println("Error!");
        }
    }

    public void print() {
        for (int i = 0; i < countDates; i++) {
            dateList[i].print();
        }
    }

    // Tạo 1 array gồm n phần tử <= MAX_NUMBER_DATES có giá trị date ngẫu nhiên
    public DateUtils(int n) {
        if (n > MAX_NUMBER_DATES) {
            System.out.println("Error! Not enough slot!");
            return;
        } else {
            Random RandomDigit = new Random();
            for (int i = 0; i < n; i++) {
                MyDate date = new MyDate();
                date.setYear(RandomDigit.nextInt(2000) + 1000);
                date.setMonth(RandomDigit.nextInt(12) + 1);
                date.setDay(RandomDigit.nextInt(28) + 1);
                addDate(date);
            }
        }
    }

}
