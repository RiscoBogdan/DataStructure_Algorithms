package DataStructure_Algorithms.InternTehnicalCodingTest;
import java.util.Scanner;
import java.util.Stack;

import java.lang.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;


 class test{

    public static String CountingMinutesI(String str) {


        String startTime = new String();
        String endTime = new String();

        Date date1 = new Date();
        Date date2 = new Date();

        String[]times = str.split("-");

        startTime = times[0];
        endTime = times[1];

        try{
            date1=new SimpleDateFormat("HH:mm").parse(startTime);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }

        try{
            date2=new SimpleDateFormat("HH:mm").parse(endTime);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }

        long difference = date2.getTime() - date1.getTime();

        str = ""+difference/1000/60;

        return str;
    }

    public static void main(String []args){
        //CountingMinutesI("10:00am-13:00pm");
        Scanner s = new Scanner(System.in);
        System.out.print(CountingMinutesI(s.nextLine()));
    }
}

public class Telenav_BracketMatcher_TimeDifference {
    public static String BracketMatcher(String str) {
        Stack<Character> stack = new Stack();
        char[] arr = str.toCharArray();
        if (arr.length == 1) {
            return str = "0";
        }
        for (int i = 0; i < str.length(); i++) {
            if (arr[i] != '(' && arr[i] != ')') {
                arr[i] = '0';
            }
        }
        for (char ch : arr) {

            if (!stack.isEmpty() && stack.peek() == '(' && ch == ')') {
                stack.pop();
            } else {
                stack.push(ch);
            }
            if (!stack.isEmpty() && stack.peek() == '0') {
                stack.pop();
            }
        }
        if (stack.isEmpty()) {
            return str = "1";
        } else {
            return str = "0";
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print(BracketMatcher(s.nextLine()));
    }
}

