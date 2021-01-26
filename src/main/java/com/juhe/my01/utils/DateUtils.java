package com.juhe.my01.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * ClassName: DateUtils
 * Description:
 * date: 2021/1/9 16:46
 *
 * @author ZouQi
 * @version 1.0
 * @since JDK 1.8
 */
public class DateUtils {

        public static final String DATE_FRORMAT_8 = "yyyyMMdd";
        public static final String DATE_FRORMAT_11 = "yyyy年MM月dd日";
        public static final String DATE_FRORMAT_14 = "yyyyMMddHHmmss";

        public DateUtils() {
        }

        public static String getDateStr14(Date date) {
            SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
            return sf.format(date);
        }

        public static Date getDate14(String dateStr) {
            if (dateStr == null) {
                return null;
            } else {
                SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");

                try {
                    return sf.parse(dateStr);
                } catch (ParseException var3) {
                    var3.printStackTrace();
                    return null;
                }
            }
        }

        public static String getDateStr11(Date date) {
            SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日");
            return sf.format(date);
        }

        public static String getDate8(Date date) {
            return format(date, "yyyyMMdd");
        }

        public static String format(Date date, String format) {
            SimpleDateFormat fm = new SimpleDateFormat(format);
            return fm.format(date);
        }

        public static Date getMonthFirstDate() {
            Calendar c = Calendar.getInstance();
            c.add(2, 0);
            c.set(5, 1);
            return new Date(c.getTimeInMillis());
        }

        public static Date getMonthLastDate() {
            Calendar c = Calendar.getInstance();
            c.set(5, c.getActualMaximum(5));
            return new Date(c.getTimeInMillis());
        }

        public static Date parseDateTime(String date) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            try {
                return format.parse(date);
            } catch (ParseException var3) {
                return null;
            }
        }


}
