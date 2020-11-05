package com.deyuan.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    //日期转换字符串
    public  static  String date2String(Date date , String patt){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patt);
        String format = simpleDateFormat.format(date);
        return  format;

    }

    //字符串转换日期
    public static Date String2date(String str,String patt){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patt);
        try {
            Date date = simpleDateFormat.parse(str);
            return date;
        } catch (ParseException e) {
         throw new RuntimeException("日期格式转换异常");
        }
    }
}
