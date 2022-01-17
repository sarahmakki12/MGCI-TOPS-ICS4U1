/*Date Class Quiz
Mr. Jay
ICS4U1-02
Sarah Ali
May 2020*/

package com.company;

public class Date {
    private int month, day;

    public Date (int m, int d) {
        month = m;
        day = d;
    }

    public String toString () {
        return month + "/" + (day < 10 ? "0" + day : day);
    }

    public void advance () {
        int [] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (day + 1 > days[month - 1]) {
            day = 1;
            month = month + 1 > 12 ? 1 : month + 1;
        } else {
            day++;
        }
    }

    public static void main (String[] args) {
        Date lastDay = new Date(6, 17);
        lastDay.advance();
        System.out.print("The next day is " + lastDay);
    }
}
