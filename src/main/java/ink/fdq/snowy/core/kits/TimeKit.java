package ink.fdq.snowy.core.kits;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

public class TimeKit {
    public static String[] WEEK_STRING_LONG = {"", "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
    public static String[] WEEK_STRING_MID = {"", "周日", "周一", "周二", "周三", "周四", "周五", "周六"};


    /**
     * 将时间从一个时区转换到另一个时区
     *
     * @param time
     * @param tz1
     * @param tz2
     * @return
     */
    public static long convertTimeZone(long time, TimeZone tz1, TimeZone tz2) {
        int diffTime = tz2.getRawOffset() - tz1.getRawOffset();

        return time + diffTime;
    }

    /**
     * 计算时区, -12 ~ 12
     *
     * @param timeZone
     * @return
     */
    public static int getTimeZoneValue(TimeZone timeZone) {
        return timeZone.getRawOffset() / (3600 * 1000);
    }

    public static int getCurrentTimeZoneValue() {
        return getTimeZoneValue(TimeZone.getDefault());
    }

    /**
     * 按照给定的模式格式化日期
     *
     * @param date    Date
     * @param pattern String 格式化模式,如 "yyyy年MM月dd日 E HH:mm:ss.SSS" 将把日期格式化为 "2008年05月20日 星期二 14:21:10.781"
     * @return
     */
    public static String format(Date date, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

    public static String format(Date date, String pattern, TimeZone timeZone, Locale locale) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, locale);
        simpleDateFormat.setTimeZone(timeZone);
        return simpleDateFormat.format(date);
    }

    /**
     * 按照默认格式格式化日期
     *
     * @param date Date
     * @return String
     */
    public static String format2(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }
    public static String format(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 E HH:mm:ss.SSS");
        return simpleDateFormat.format(date);
    }
    public static String format(Calendar date, String pattern) {
        if (date == null) {
            return "0000-00-00 00:00:00";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date.getTime());
    }

    /**
     * 解析日期文本与format刚好相反
     *
     * @param text    String
     * @param pattern String
     * @return Date
     */
    public static Date parse(String text, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        ParsePosition pos = new ParsePosition(0);
        Date date = simpleDateFormat.parse(text, pos);
        if (pos.getIndex() < text.length()) {
            throw new RuntimeException("错误索引信息 : " + pos.getErrorIndex());
        }
        return date;
    }

    public static Date parse(String text, String pattern, TimeZone timeZone, Locale locale) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, locale);
        simpleDateFormat.setTimeZone(timeZone);
        ParsePosition pos = new ParsePosition(0);
        Date date = simpleDateFormat.parse(text, pos);
        if (pos.getIndex() < text.length()) {
            throw new RuntimeException("错误索引信息 : " + pos.getErrorIndex());
        }
        return date;
    }

    public static Calendar parse2(String text, String pattern) {
        Date date = parse(text, pattern);
        return dateToCalender(date);
    }

    public static java.sql.Date parse3(String text, String pattern) {
        Date date = parse(text, pattern);
        return new java.sql.Date(date.getTime());
    }

    public static Calendar dateToCalender(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    /**
     * 计算两个日期相差多少天
     *
     * @param d1 Date
     * @param d2 Date
     * @return long
     */
    public static long subtract(Date d1, Date d2) {
        BigDecimal timeQuantum = new BigDecimal(0);
        BigDecimal bd1 = new BigDecimal(d1.getTime());
        BigDecimal bd2 = new BigDecimal(d2.getTime());
        BigDecimal day = new BigDecimal(24L * 60 * 60 * 1000);
        timeQuantum = bd1.subtract(bd2).divideToIntegralValue(day);
        return timeQuantum.longValue();
    }

    /**
     * 计算两个日期相差多少小时
     *
     * @param d1 Date
     * @param d2 Date
     * @return long
     */
    public static long subtractHour(Date d1, Date d2) {
        BigDecimal timeQuantum = new BigDecimal(0);
        BigDecimal bd1 = new BigDecimal(d1.getTime());
        BigDecimal bd2 = new BigDecimal(d2.getTime());
        BigDecimal hour = new BigDecimal(60L * 60 * 1000);
        timeQuantum = bd1.subtract(bd2).divideToIntegralValue(hour);
        return timeQuantum.longValue();
    }

    /**
     * 计算两个日期相差多少分钟
     *
     * @param d1 Date
     * @param d2 Date
     * @return long
     */
    public static long subtractMinute(Date d1, Date d2) {
        BigDecimal timeQuantum = new BigDecimal(0);
        BigDecimal bd1 = new BigDecimal(d1.getTime());
        BigDecimal bd2 = new BigDecimal(d2.getTime());
        BigDecimal minute = new BigDecimal(60L * 1000);
        timeQuantum = bd1.subtract(bd2).divideToIntegralValue(minute);
        return timeQuantum.longValue();
    }

    /**
     * 计算两个日期相差多少秒
     *
     * @param d1 Date
     * @param d2 Date
     * @return long
     */
    public static long subtractSecond(Date d1, Date d2) {
        BigDecimal timeQuantum = new BigDecimal(0);
        BigDecimal bd1 = new BigDecimal(d1.getTime());
        BigDecimal bd2 = new BigDecimal(d2.getTime());
        BigDecimal second = new BigDecimal(1000L);
        timeQuantum = bd1.subtract(bd2).divideToIntegralValue(second);
        return timeQuantum.longValue();
    }

    public static Date add(Date date, int field, int amount) {
        Calendar afterTime = Calendar.getInstance();
        afterTime.setTime(date);
        afterTime.add(field, amount);
        return afterTime.getTime();
    }

    /**
     * 解析一个时间间隔
     *
     * @param quantum long 用毫秒数表示的时间段
     * @return String
     */
    public static String parseTimeQuantum(long quantum) {
        long day = 0L;
        long hour = 0;
        long minute = 0;
        long second = 0;
        long millisecond = 0;
        long tmp = 0L;

        if (quantum < 1000) {
            millisecond = quantum;
            return millisecond + "毫秒";
        }

        millisecond = quantum % 1000L;
        second = quantum / 1000L;
        if (second < 60) {
            return second + "秒" + millisecond + "毫秒";
        }

        tmp = second;
        second = tmp % 60L;
        minute = tmp / 60L;
        if (minute < 60) {
            return minute + "分钟" + second + "秒" + millisecond + "毫秒";
        }

        tmp = minute;
        minute = tmp % 60L;
        hour = tmp / 60L;
        if (hour < 24) {
            return hour + "小时" + minute + "分钟" + second + "秒" + millisecond + "毫秒";
        }

        tmp = hour;
        hour = tmp % 24L;
        day = tmp / 24L;

        return day + "天" + hour + "小时" + minute + "分钟" + second + "秒" + millisecond + "毫秒";
    }

    public static String getCurrentDateText() {
        return format(new Date(), "yyyy年MM月dd日 E HH:mm:ss.SSS");
    }

    public static boolean isZero(Date date) {
        return date.getTime() == -62170185600000L;
    }

    public static int getCurrentYear() {
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.YEAR);
    }

    public static int getCurrentMonth() {
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.MONTH) + 1;
    }

    public static Date getFirstDayOfCurrentMonth() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);

        return c.getTime();
    }

    public static Date getPreviousMonthBegin() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.MONTH, c.get(Calendar.MONTH) - 1);
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    public static Date getCurrentMonthBegin() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    public static XMLGregorianCalendar toXMLCalendar(Date d) throws DatatypeConfigurationException {

        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(d);
        XMLGregorianCalendar xml = DatatypeFactory.newInstance().newXMLGregorianCalendar();
        xml.setYear(gc.get(Calendar.YEAR));
        xml.setMonth(gc.get(Calendar.MONTH) + 1);
        xml.setDay(gc.get(Calendar.DAY_OF_MONTH));
        xml.setHour(gc.get(Calendar.HOUR_OF_DAY));
        xml.setMinute(gc.get(Calendar.MINUTE));
        xml.setSecond(gc.get(Calendar.SECOND));
        return xml;
    }

    public static Date toDate(XMLGregorianCalendar x) {
        GregorianCalendar gc = x.toGregorianCalendar();
        Date date = gc.getTime();
        return date;
    }

    public static int computeAge(Date birthDay) {
        Calendar cal = Calendar.getInstance();

        if (cal.before(birthDay)) {
            throw new IllegalArgumentException(
                    "The birthDay is before Now.It's unbelievable!");
        }

        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH);
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(birthDay);

        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

        int age = yearNow - yearBirth;

        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                //monthNow==monthBirth
                if (dayOfMonthNow < dayOfMonthBirth) {
                    age--;
                } else {
                    //do nothing
                }
            } else {
                //monthNow>monthBirth
                age--;
            }
        } else {
            //monthNow<monthBirth
            //donothing
        }

        return age;
    }


    public static int getWeek(int diff) {
        Calendar calendar = Calendar.getInstance();
        int week = calendar.get(Calendar.DAY_OF_WEEK);
        week = ((week + diff) >= 8) ? ((week + diff) % 8 + 1) : ((week + diff) % 8);
        return week;
    }

    /**
     * 星期一形式星期
     *
     * @param diff
     * @return
     */
    public static String getTodayCnLongWeek() {
        int week = getWeek(0);
        return WEEK_STRING_LONG[week];
    }

    public static String getTodayCnLongWeek(int diff) {
        int week = getWeek(diff);
        return WEEK_STRING_LONG[week];
    }

    /**
     * 周一 形式星期
     *
     * @param diff
     * @return
     */
    public static String getTodayCnMidWeek() {
        int week = getWeek(0);
        return WEEK_STRING_MID[week];
    }

    public static String getTodayCnMidWeek(int diff) {
        int week = getWeek(diff);
        return WEEK_STRING_MID[week];
    }


    public static void main(String[] args) {
        System.out.println(TimeKit.getTodayCnLongWeek());
    }


}
