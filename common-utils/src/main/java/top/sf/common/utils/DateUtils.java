package top.sf.common.utils;

import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description 日期工具
 * @Author: Yb.Z
 * @Date: 2019-11-17.09:05
 * @Version：1.0
 */
public class DateUtils {

    private static Map<FormatterPattern,DateTimeFormatter> formatters = new ConcurrentHashMap<>();

    static {
        Arrays.stream(FormatterPattern.values()).forEach(pattern ->
                formatters.put(pattern,getDateTimeFormatter(pattern)));
    }

    @Getter
    public enum FormatterPattern {

        YMD("yyyyMMdd"),

        YMD_HMS(YMD.getPattern() + " HHmmss"),

        YMD_WITH_HYPHEN("yyyy-MM-dd"),

        YMD_HMS_WITH_HYPHEN(YMD_WITH_HYPHEN.getPattern() + " HH:mm:ss");

        private String pattern;

        FormatterPattern(String pattern) {
            this.pattern = pattern;
        }

    }

    public static final String formatDate(Temporal datetime,FormatterPattern pattern){
        DateTimeFormatter formatter = formatters.get(pattern);
        return formatter.format(datetime);
    }


    public static final String formatDateTime(Temporal datetime,FormatterPattern pattern){
        DateTimeFormatter formatter = formatters.get(pattern);
        return formatter.format(datetime);
    }


    private static DateTimeFormatter getDateTimeFormatter(FormatterPattern pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern.getPattern());
        return formatter;
    }

    public static void main(String[] args) {
        System.out.println(formatDateTime(LocalDateTime.now(), FormatterPattern.YMD_HMS_WITH_HYPHEN));
    }
}
