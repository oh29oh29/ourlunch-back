package pe.oh29oh29.ourlunch.util;

import pe.oh29oh29.ourlunch.constants.DateFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    public static String now() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(DateFormat.yyyyMMddHHmmss));
    }

    public static String format(LocalDateTime localDateTime, String format) {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return localDateTime.format(formatter);
    }
}
