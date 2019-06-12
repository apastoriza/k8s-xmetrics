package com.k8s.xmetrics.datetime;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.TimeZone;

/**
 * @author apastoriza
 */
public class DateTimeUtils {
	private static final Logger LOGGER = LoggerFactory.getLogger(DateTimeUtils.class);
	private static final DateTimeFormatter ISO_DATE_TIME_FORMAT = ISODateTimeFormat.dateTimeNoMillis();

	private static final String LOCAL_DATE_PATTERN = "yyyyMMdd";

	private static final String LOCAL_DATE_TIME_PATTERN = "yyyyMMddHHmmss";

	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormat.forPattern(LOCAL_DATE_PATTERN);

	private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormat.forPattern(LOCAL_DATE_TIME_PATTERN);

	private static final String TIME_ZONE_ID = "CET";


	public static DateTime getDateTime() {
		return getDateTime(systemTimeZone());
	}


	public static DateTime getDateTime(final DateTimeZone dateTimeZone) {
		return new DateTime(dateTimeZone);
	}

	public static DateTime getDateTime(final long millis, final DateTimeZone dateTimeZone) {
		final DateTime dateTime = new DateTime(millis, dateTimeZone);
		LOGGER.debug("Date Time for {} millis at '{}': {}", millis, dateTimeZone, dateTime);
		return dateTime;
	}

	public static DateTime getDateTime(final long millis) {
		return getDateTime(millis, systemTimeZone());
	}

	public static DateTime fromIsoStringToDateTime(final String isoDateTimeAsString, final boolean forceCurrent) {
		DateTime dateTime = null;
		if (isoDateTimeAsString != null && !isoDateTimeAsString.isEmpty()) {
			dateTime = ISO_DATE_TIME_FORMAT.parseDateTime(isoDateTimeAsString);
		} else if (forceCurrent) {
			dateTime = getDateTime();
			LOGGER.trace("Forced Date: {}", dateTime);
		}
		return dateTime;
	}

	public static DateTime fromStringValuesToDateTime(final String year, final String month) {
		return fromStringValuesToDateTime(year, month, "01");
	}

	public static DateTime fromStringValuesToDateTime(final String year, final String month, final String days) {
		final String isoDateTimeAsString = year.concat("-").concat(month).concat("-").concat(days).concat("T00:00:00Z");
		return fromIsoStringToDateTime(isoDateTimeAsString);
	}

	public static DateTime fromIsoStringToDateTime(final String isoDateTimeAsString) {
		return fromIsoStringToDateTime(isoDateTimeAsString, false);
	}

	public static String fromMillisToDateAsString(final long recordedTimeInMillis) {
		return fromMillisToDateAsString(recordedTimeInMillis, systemTimeZone());
	}

	public static String fromMillisToDateAsString(final long recordedTimeInMillis, final DateTimeZone dateTimeZone) {
		final DateTime dateTime = getDateTime(recordedTimeInMillis, dateTimeZone);
		return DATE_FORMATTER.print(dateTime);
	}

	public static String fromMillisToDateTimeAsString(final long recordedTimeInMillis) {
		return fromMillisToDateTimeAsString(recordedTimeInMillis, systemTimeZone());
	}

	public static String fromMillisToDateTimeAsString(final long recordedTimeInMillis, final DateTimeZone dateTimeZone) {
		final DateTime dateTime = getDateTime(recordedTimeInMillis, dateTimeZone);
		return DATE_TIME_FORMATTER.print(dateTime);
	}

	public static LocalDate today() {
		return new LocalDate();
	}


	public static LocalDate newLocalDate(final long millis) {
		return new LocalDate(millis, systemTimeZone());
	}

	public static Long getMillis(final LocalDate localDate) {
		final DateTime dateTime = localDate.toDateTimeAtCurrentTime();
		return dateTime.getMillis();
	}

	public static Long nowInMillis() {
		return getDateTime(systemTimeZone()).getMillis();
	}

	public static int daysBetweenToday(final LocalDate end) {
		return daysBetween(today(), end);
	}

	public static int daysBetween(final LocalDate start, final LocalDate end) {
		return Days.daysBetween(start, end).getDays();
	}


	private static DateTimeZone systemTimeZone(){
		return DateTimeZone.forTimeZone(TimeZone.getTimeZone(TIME_ZONE_ID));
	}
}
