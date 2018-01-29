package utils;

import java.sql.Date;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;

public final class DateUtils {

	private DateUtils() {

	}

	public static int getCurrentDate() {

		Format dtf = new SimpleDateFormat("yyyyMMddHHmmss");

		return   Integer.parseInt(dtf.format(Calendar.getInstance().getTime()));
	}
}
