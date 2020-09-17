package com.directrent.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * @description: 日期处理工具类
 * @author: YX
 * @date: 2020/09/07 11:23
 */
public class DateUtils {
    private final static Logger logger = LoggerFactory.getLogger(DateUtils.class);
    /**
     * 时间格式(yyyy-MM-dd)
     */
    public final static String DATE_PATTERN = "yyyy-MM-dd";
    public final static String DATE_PATTERN_APP = "yyyy.MM.dd";
    public final static String DATE_PATTERN_NOSPLIT = "yyyyMMdd";

    /**
     * 时间格式(yyyy-MM-dd HH:mm:ss)
     */
    public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**时间类型转换*/
    public static LocalDateTime javaDate2LocalDateTime(Date date){
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**时间类型转换*/
    public static Date localDateTime2JavaDate(LocalDateTime localDatetime){
        return Date.from(localDatetime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**等同于System.currentTimeMillis(),返回本地时区时间戳,返回毫秒*/
    public static long localDateTimeToMilSec(LocalDateTime localDatetime){
        return localDatetime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**等同于System.currentTimeMillis(),返回本地时区时间戳,返回秒*/
    public static long localDateTimeToSec(LocalDateTime localDatetime){
        return localDatetime.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
    }

    public static String format(Date date) {
        return format(date, DATE_PATTERN);
    }

    public static String format(Date date, String pattern) {
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return df.format(date);
        }
        return null;
    }

    /**
     * 字符串转日期
     * @param dateStr  待转字符串
     * @param format  格式
     * @return
     */
    public static Date strToDate(String dateStr, String format){
        if (dateStr == null || "".equals(dateStr) || format == null || "".equals(format)){
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date;
    }
    
    /**
     * 计算距离现在多久，非精确
     *
     * @param date
     * @return
     */
    public static String getTimeBefore(Date date) {
        Date now = new Date();
        long l = now.getTime() - date.getTime();
        long day = l / (24 * 60 * 60 * 1000);
        long hour = (l / (60 * 60 * 1000) - day * 24);
        long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        String r = "";
        if (day > 0) {
            r += day + "天";
        } else if (hour > 0) {
            r += hour + "小时";
        } else if (min > 0) {
            r += min + "分";
        } else if (s > 0) {
            r += s + "秒";
        }
        r += "前";
        return r;
    }

    /**
     * 计算距离现在多久，精确
     *
     * @param date
     * @return
     */
    public static String getTimeBeforeAccurate(Date date) {
        Date now = new Date();
        long l = now.getTime() - date.getTime();
        long day = l / (24 * 60 * 60 * 1000);
        long hour = (l / (60 * 60 * 1000) - day * 24);
        long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        String r = "";
        if (day > 0) {
            r += day + "天";
        }
        if (hour > 0) {
            r += hour + "小时";
        }
        if (min > 0) {
            r += min + "分";
        }
        if (s > 0) {
            r += s + "秒";
        }
        r += "前";
        return r;
    }
    
    /**
     * 当前时间类型   6:00:00 - 17:59:59 这个表示早班(1表示早班)   18:00:00-5:59:59 表示晚班(2表示晚班)
     * @return
     */
    public static String nowType(){
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        if (hour >= 6 && hour <=17){
            return "1";
        } else{
            return "2";
        }
    }
    
    /**
     * 判断当前日期是星期几
     * 
     */
     public static int dayForWeek(Date pTime){
         Calendar c = Calendar.getInstance();
         c.setTime(pTime);
         int dayForWeek = 0;
         if (c.get(Calendar.DAY_OF_WEEK) == 1){
             dayForWeek = 7;
         } else{
             dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
         }
         return dayForWeek;
     }
     
     /**
      * 判断当前日期是星期几
      * 
      * @param pTime 修要判断的时间
      * @return dayForWeek 判断结果
      * @Exception 发生异常
      */
     public static int dayForWeek(String pTime) throws Exception {
         SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
         Calendar c = Calendar.getInstance();
         c.setTime(format.parse(pTime));
         int dayForWeek = 0;
         if (c.get(Calendar.DAY_OF_WEEK) == 1){
             dayForWeek = 7;
         } else{
             dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
         }
         return dayForWeek;
     }
    /*
     * 获取当前时间的和2小时后的时间段
     * */
     public static Map<String,Object> getNextDayTime(){
         Map<String,Object> params = new HashMap<>();
         SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         Calendar calendarStart =Calendar.getInstance();
         Calendar calendarEnd =Calendar.getInstance();
         calendarEnd.set(calendarStart.get(Calendar.YEAR), calendarStart.get(Calendar.MONTH), calendarStart.get(Calendar.DATE), 
         calendarStart.get(Calendar.HOUR_OF_DAY)+2, calendarStart.get(Calendar.MINUTE), calendarStart.get(Calendar.SECOND));
         String calendarStartTime = formatter.format(calendarStart.getTime());
         String calendarEndTime = formatter.format(calendarEnd.getTime());
         params.put("calendarStartTime", calendarStartTime);
         params.put("calendarEndTime", calendarEndTime);
         return params;
    }

    /**
     * @author wangqiang
     * @date 2018/4/19 14:14
     * @param date 需要处理的时间
     * @return java.util.Date  当天最后一秒的date
     */
    public static Date getLastSec4Today(Date date) {
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        String str=format.format(date);
        Date d2 = null;
        try {
            d2=format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int dayMis=1000*60*60*24;
        long curMillisecond=d2.getTime();
        long resultMis=curMillisecond+(dayMis-1);
        Date resultDate=new Date(resultMis);
        return resultDate;
    }


    public static int getDiffDays(Date day1,Date day2){
        Long day1Time = day1.getTime();
        Long day2Time = day2.getTime();
        Long difftime = day1Time - day2Time;
        if(difftime<0){
            difftime = -difftime;
        }
        Long diffDays =  difftime / (1000 * 60 * 60 * 24);

        return Integer.parseInt(String.valueOf(diffDays));
    }
     
     

    /**
     *  获取当天的最后一秒（23:59:59)
     */
    public static Date getEndMinOfDay(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        Date dt2 = calendar.getTime();

        return dt2;
    }

    /**
     *  获取当天的0点0分（00:00:00)
     */
    public static Date getStartMinOfDay(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date dt2 = calendar.getTime();
        return dt2;
    }

    /**
     * 时间减少一秒
     */
    public static Date subSecond(Date date){
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.SECOND, -1);
        Date dt1 = rightNow.getTime();
//        String reStr = sdf.format(dt1);
        return dt1;
    }

    /**
     * 时间增加一秒
     */
    public static Date addSecond(Date date) {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.SECOND, +1);
        Date dt1 = rightNow.getTime();
//        String reStr = sdf.format(dt1);
        return dt1;
    }
    /*传入时间加减n年*/
    public static String addYear(Date date,int years){
        Calendar rightNow=Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.YEAR,years);
        return format(rightNow.getTime(),DATE_PATTERN);
    }
    /*传入时间加减n天*/
    public  static Date addDays(Date date ,int days){
        Calendar rightNow=Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.DATE,days);
        return rightNow.getTime();
    }
    /**
     * 判断是否是同一天
     * @param d1
     * @param d2
     * @return
     */
    public static boolean isSameDate(Date d1, Date d2) {
        LocalDate localDate1 = ZonedDateTime.ofInstant(d1.toInstant(), ZoneId.systemDefault()).toLocalDate();
        LocalDate localDate2 = ZonedDateTime.ofInstant(d2.toInstant(), ZoneId.systemDefault()).toLocalDate();
        return localDate1.isEqual(localDate2);
    }

    /**
     * 获取当年的第一天
     * @return
     */
    public static Date getCurrYearFirst(){
        Calendar currCal=Calendar.getInstance();
        int currentYear = currCal.get(Calendar.YEAR);
        return getYearFirst(currentYear);
    }

    /**
     * 获取当年的最后一天
     * @return
     */
    public static Date getCurrYearLast(){
        Calendar currCal=Calendar.getInstance();
        int currentYear = currCal.get(Calendar.YEAR);
        return getYearLast(currentYear);
    }

    /**
     * 获取某年第一天日期
     * @param year 年份
     * @return Date
     */
    public static Date getYearFirst(int year){
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        Date currYearFirst = calendar.getTime();
        return currYearFirst;
    }

    /**
     * 获取某年最后一天日期
     * @param year 年份
     * @return Date
     */
    public static Date getYearLast(int year){
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        Date currYearLast = calendar.getTime();

        return currYearLast;
    }

    /***
     * 判断是否同一天
     * @param day1
     * @param day2
     * @return
     */
    public static boolean isSameDay(Date day1,Date day2){

        String day1Str = format(day1,DATE_PATTERN);
        String day2Str = format(day2,DATE_PATTERN);

        if(day1Str.equals(day2)){
            return true;
        }else{
            return false;
        }
    }
    /*获取n个月的最后一天*/
    public static Date getMaxMonthDate(int m) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, m);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
    }
    /*获取n个月的第一天*/
    public static Date getMinMonthDate(int m) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, m);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
    }
    /*获取某个月的下个月的最后一天，比如获取2019-07-21的第m个月的最后一天*/
    public static String getTheNextMonthMaxDate(Date date,int m){
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH,m);
        calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
       return  format(calendar.getTime(),DATE_PATTERN);
    }


    /**
     * localdate 转 date
     * @param localDate
     * @return
     */
    public static Date localDateToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }


    /**
     * localDateTime 转 date
     * @param localDateTime
     * @return
     */
    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }


    /**
     * date 转 localDate
     * @param date
     * @return
     */
    public static LocalDate dateToLocalDate(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).toLocalDate();
    }


    /**
     * date 转 localDateTime
     * @param date
     * @return
     */
    public static LocalDateTime dateToLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * 日期加减
     * @param date 日期
     * @param unit 单位(年月周日时分秒毫秒皆可)
     * @param count 数量(负为减)
     * @return
     */
    public static Date datePlus(Date date, ChronoUnit unit, int count) {
        return localDateTimeToDate(dateToLocalDateTime(date).plus(count, unit));
    }


    /**
     * 日期加减
     * @param date
     * @param unit
     * @param count
     * @param returnFormat 返回格式
     * @return
     */
    public static String datePlus(Date date, ChronoUnit unit, int count, String returnFormat) {
        return DateTimeFormatter.ofPattern(returnFormat).format(dateToLocalDateTime(date).plus(count, unit));
    }


    /**
     * 日期格式化
     * @param date
     * @param returnFormat
     * @return
     */
    public static Date formatOfDate(Date date, String returnFormat) {
        return localDateToDate(LocalDate.parse(DateTimeFormatter.ofPattern(returnFormat).format(dateToLocalDate(date))));
    }

    /**
     * 日期格式化-字符串
     * @param date
     * @param returnFormat
     * @return
     */
    public static String formatOfStr(Date date, String returnFormat) {
        return DateTimeFormatter.ofPattern(returnFormat).format(dateToLocalDate(date));
    }
    /*
    * 获取两个日期之间的所有日期集合,开始日期要小于结束日期，返回集合包含开始日期和结束日期
    * */
    public static List<Date> getBetweenDates(Date start, Date end) {
        List<Date> result = new ArrayList<Date>();
        Calendar tempStart = Calendar.getInstance();
        tempStart.setTime(start);
        tempStart.add(Calendar.DAY_OF_YEAR, 1);
        Calendar tempEnd = Calendar.getInstance();
        tempEnd.setTime(end);
        result.add(start);
        while (tempStart.before(tempEnd)) {
            result.add(tempStart.getTime());
            tempStart.add(Calendar.DAY_OF_YEAR, 1);
        }
        return result;
    }

}
