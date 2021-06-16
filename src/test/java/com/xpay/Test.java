package com.xpay;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Test {
    public static String getTimestampTimeV16(String str) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        TimeZone tz = TimeZone.getTimeZone("Asia/Shanghai");
        sdf.setTimeZone(tz);
        Date date = sdf.parse(str);
        String string = date.toString();
        System.out.println(string);
        return string;
    }

    public static String getTimestampTimeV17(String str) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'XXX");
        Date date = sdf.parse(str);
        String string = date.toString();
        System.out.println(string);
        return string;
    }

    public static void main(String[] args) throws ParseException {
        String x = "2015-12-27T14:20:34Z+08:00";
        Test.getTimestampTimeV17(x);
    }
}
