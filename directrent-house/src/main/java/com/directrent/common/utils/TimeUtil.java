package com.directrent.common.utils;

import com.directrent.common.enums.DateType;
import com.directrent.common.exception.BusinessException;
import com.directrent.common.exception.ExceptionDefin;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

/**
 * @PackageName: com.just.butterfly.biz.common.util
 * @Description:
 * @author: traveller
 * @date: 2018/8/24 11:29
 * @Copyright: 2018 www. .com Inc. All rights reserved.
 * 注意：本内容仅限于西藏佳斯特信息技术有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class TimeUtil {

    private static final Logger logger = LoggerFactory.getLogger(TimeUtil.class);

    public static final String DATE = "yyyy-MM-dd";
    public static final String DATE_TIME = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_TIME_HH = "yyyy-MM-dd HH";
    public static final String DATE_TIME_HH_MM = "yyyy-MM-dd HH:mm";
    public static final String HH_MM_SS = "HH:mm:ss";

    public static int betweenMinute(Date startTime, Date endTime) {
        int sec = betweenSec(startTime, endTime);
        return new Double(Math.ceil((double) sec / 60)).intValue();
    }

    public static int betweenHour(Date startTime, Date endTime) {
        return (int) between(startTime, endTime).toHours();
    }

    private static Duration between(Date startTime, Date endTime) {
        Instant startTimeIns = startTime.toInstant();
        Instant endTimeIns = endTime.toInstant();
        Duration duration = Duration.between(startTimeIns, endTimeIns);
        return duration;
    }

    /**
     * 计算两个时间相差的天数 超过1天 +1天
     * @param startTime
     * @param endTime
     * @return
     */
    public static int betweenDays(Date startTime,Date endTime){
        long toHours = between(startTime, endTime).toHours();
        if (toHours % 24 > 0){
            return (int) between(startTime,endTime).toDays() + 1;
        }

        return (int) between(startTime,endTime).toDays();
}
    public static int betweenSec(Date starTime, Date endTIme) {
        return (int) ((endTIme.getTime() - starTime.getTime()) / 1000);
    }

    public static long toMillSecendDay() {
        long l = System.currentTimeMillis();
        DateTime dateTime = DateTime.now().plusDays(1).withTime(0, 0, 0, 0);
        long time = dateTime.toDate().getTime();
        return time - l;
    }

    /**
     * 通用字符串转换为日期时间.
     */
    public static Date parseDate(String isDateString) {
        Date tcDate = null;
        if (isDateString != null && !isDateString.equals("")) {
            if (isDateString.contains(" ")) {
                if (isDateString.contains(":")) {
                    // 包含时间
                    try {
                        SimpleDateFormat tcDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        tcDate = tcDateFormat.parse(isDateString);
                        return tcDate;
                    } catch (Exception e) {

                    }
                    try {
                        SimpleDateFormat tcDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                        tcDate = tcDateFormat.parse(isDateString);
                        return tcDate;
                    } catch (Exception e) {

                    }
                } else {
                    // 不包含时间
                    try {
                        SimpleDateFormat tcDateFormat = new SimpleDateFormat("yyyy-MM-dd HH");
                        tcDate = tcDateFormat.parse(isDateString);
                        return tcDate;
                    } catch (Exception e) {

                    }
                }
            } else {
                try {
                    SimpleDateFormat tcDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    tcDate = tcDateFormat.parse(isDateString);
                    return tcDate;
                } catch (Exception e) {

                }

                try {
                    SimpleDateFormat tcDateFormat = new SimpleDateFormat("公元yyyy年MM月dd日");
                    tcDate = tcDateFormat.parse(isDateString);
                    return tcDate;
                } catch (Exception e) {

                }

                try {
                    SimpleDateFormat tcDateFormat = new SimpleDateFormat("yyyy-MM");
                    tcDate = tcDateFormat.parse(isDateString);
                    return tcDate;
                } catch (Exception e) {

                }
                try {
                    SimpleDateFormat tcDateFormat = new SimpleDateFormat("HH:mm");
                    tcDate = tcDateFormat.parse(isDateString);
                    return tcDate;
                } catch (Exception e) {

                }
            }
        }
        return tcDate;
    }

    public static Date convertDate(String dateTime, String returnFormat) {
        Date time = null;
        try {
            time = parseDate(dateTime);
            DateFormat df = new SimpleDateFormat(returnFormat);
            return df.parse(df.format(time));
        } catch (Exception e) {
            e.printStackTrace();
            return time;
        }
    }

    public static String formatDate(Date date, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);

        return format.format(date);
    }

    /**
     * 日，月, 周，年加减
     *
     * @param date         日期
     * @param dateType     日期类型
     * @param count        加减数量
     * @param returnFormat 结果返回格式
     * @return
     */
    public static String dateAddOrSub(Date date, DateType dateType, int count, String returnFormat) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        switch (dateType) {
            case DAY:
                calendar.add(Calendar.DAY_OF_YEAR, count);
                break;
            case WEEK:
                calendar.add(Calendar.WEEK_OF_YEAR, count);
                break;
            case MONTH:
                calendar.add(Calendar.MONTH, count);
                break;
            case YEAR:
                calendar.add(Calendar.YEAR, count);
                break;
        }
        Date resultDate = calendar.getTime();
        return new SimpleDateFormat(returnFormat).format(resultDate);
    }

    public static void main(String[] args) {
        //System.out.println(convertDate("2018-09-18 12:33", TimeUtil.DATE_TIME_HH_MM));
//       Integer integer = betweenDays(new Date(new Date().getTime() - 12 * 60 * 60 * 1000L) , new Date());
//        int i = 0;

        System.out.println(System.currentTimeMillis());

        System.out.println(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        System.out.println(LocalDateTime.now().atOffset(ZoneOffset.UTC).toInstant().toEpochMilli());
        System.out.println(LocalDateTime.now().atOffset(ZoneOffset.UTC).toInstant().getEpochSecond());
    }

    public static Date toDate(String notify_time, String s) {
        try {
            return new SimpleDateFormat(s).parse(notify_time);
        } catch (ParseException e) {
            logger.error(e.getLocalizedMessage(), e);
            throw new BusinessException(ExceptionDefin.PARSE_ERROR);
        }
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
     * 获取当前是周几
     */
    public static String getWeek(Long timestamp){
        if (timestamp == null){
            return null;
        }
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(timestamp);
        int i = instance.get(Calendar.DAY_OF_WEEK);
        switch (i){
            case 1:
                return "周日";
            case 2:
                return "周一";
            case 3:
                return "周二";
            case 4:
                return "周三";
            case 5:
                return "周四";
            case 6:
                return "周五";
            case 7:
                return "周六";
            default:
                return null;
        }
    }
    /**
     * 获取当前是周几
     */
    public static String getWeek(Date date){
        if (date == null){
            return null;
        }
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        int i = instance.get(Calendar.DAY_OF_WEEK);
        switch (i){
            case 1:
                return "周日";
            case 2:
                return "周一";
            case 3:
                return "周二";
            case 4:
                return "周三";
            case 5:
                return "周四";
            case 6:
                return "周五";
            case 7:
                return "周六";
            default:
                return null;
        }
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

}
