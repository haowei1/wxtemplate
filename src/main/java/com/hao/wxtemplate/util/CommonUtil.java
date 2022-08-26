package com.hao.wxtemplate.util;

import cn.hutool.core.date.ChineseDate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class CommonUtil {

    /**
     * 获取随机的颜色 #000000
     * @return
     */
    public static String getRandomColor() {
        Random random = new Random();
        String red = Integer.toHexString(random.nextInt(256)).toUpperCase();
        String green = Integer.toHexString(random.nextInt(256)).toUpperCase();
        String blue = Integer.toHexString(random.nextInt(256)).toUpperCase();
        red = red.length() == 1 ? "0"+ red : red;
        green = green.length() == 1 ? "0"+ green : green;
        blue = blue.length() == 1 ? "0"+ blue : blue;
        String color = "#" + red + green + blue;
        return color;
    }

    /**
     * 获取当前日期 yyyy年MM月dd日
     * @return
     */
    public static String getDate(String format) {
        return new SimpleDateFormat(format).format(new Date());
    }

    /**
     * 获取当前星期数
     * @return
     */
    public static String getWeek(){
        String[] weeks = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int weekIndex = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if(weekIndex<0){
            weekIndex = 0;
        }
        return weeks[weekIndex];
    }

    /**
     * 获取当前的农历信息
     * @return
     */
    public static String getCalendar(){
        return new ChineseDate(new Date()).toString();
    }

    /**
     * 获取两个日期相差天数
     * @param start
     * @param end
     * @return
     */
    public static String getDateCount(String start, String end){
        DateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date star = dft.parse(start);//开始时间
            Date endDay = dft.parse(end);//结束时间
            Long starTime = star.getTime();
            Long endTime = endDay.getTime();
            Long num = endTime - starTime;//时间戳相差的毫秒数
            long a = num/24/60/60/1000;
            return a + "";
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }
}
