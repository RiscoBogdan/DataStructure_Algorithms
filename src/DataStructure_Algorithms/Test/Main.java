package DataStructure_Algorithms.Test;

import java.util.Scanner;

class Main {


    public static String CountingMinutesI(String str) {
        String startTime = new String();
        String endTime = new String();

        String startTimeType = new String();
        String endTimeType = new String();

        String[]times = str.split("-");


        startTime = times[0];
        endTime = times[1];

        //System.out.println(startTime + "   " + endTime);

        String[] hoursMinutes = startTime.split(":");

        String startHours = hoursMinutes[0];
        String startMinutes = hoursMinutes[1];


//        startTimeType = "" + startMinutes[startMinutes.length()-1] + startMinutes[startMinutes.length()-2];


        System.out.println(startHours);
        // String test = startMinutes.substring(0, startMinutes.length()-2);

        //System.out.println("startHours: " + hoursMinutes[0] + " startMinutes: " +
        //hoursMinutes[1].substring(0, hoursMinutes.length() - 2));

//        if(startTimeType == endTimeType) {
//            //calculeaza cumva
//        } else {
//            //calculeaza altcumva
//        }

        return str;
    }

    public static void main(String[] args) {

        CountingMinutesI("05:00am-06:00am");

        Scanner s = new Scanner(System.in);
        System.out.print(CountingMinutesI(s.nextLine()));
    }


}

