package com.k8s.xmetrics.test.datetime;

import com.k8s.xmetrics.datetime.DateTimeUtils;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author apastoriza
 */
public class DateTimeUtilsTest {
	private static final long ONE_MIN_IN_MILLIS = 60L * 1000L;

	@Test
	public void testDaysBetween() {

		final DateTime now = DateTimeUtils.getDateTime(System.currentTimeMillis());
		final DateTime dateTimeIso = DateTimeUtils.getDateTime();

		Assert.assertEquals(now.dayOfYear().get(), dateTimeIso.dayOfYear().get());
		Assert.assertEquals(now.hourOfDay().get(), dateTimeIso.hourOfDay().get());
	}

	@Test
	public void shouldConvert() {
		DateTime dateTimeUnforced = DateTimeUtils.fromIsoStringToDateTime("2016-09-07T15:36:36Z");
		DateTime dateTimeForced = DateTimeUtils.fromIsoStringToDateTime("2016-09-07T15:36:36Z", true);
		Assert.assertEquals(dateTimeForced, dateTimeUnforced);

		dateTimeUnforced = DateTimeUtils.fromIsoStringToDateTime(null, false);
		dateTimeForced = DateTimeUtils.fromIsoStringToDateTime(null, true);
		Assert.assertNull(dateTimeUnforced);
		Assert.assertNotNull(dateTimeForced);

		dateTimeUnforced = DateTimeUtils.fromIsoStringToDateTime("", false);
		dateTimeForced = DateTimeUtils.fromIsoStringToDateTime("", true);
		Assert.assertNull(dateTimeUnforced);
		Assert.assertNotNull(dateTimeForced);

		final DateTime dateTimeYearAndMonth = DateTimeUtils.fromStringValuesToDateTime("2018", "12");
		final DateTime dateTimeYearMonthAndDay = DateTimeUtils.fromStringValuesToDateTime("2018", "12", "01");
		Assert.assertEquals(dateTimeYearAndMonth, dateTimeYearMonthAndDay);


		final DateTime now = DateTimeUtils.getDateTime();
		final long nowInMillis = now.getMillis();
		final String dateAsString = DateTimeUtils.fromMillisToDateAsString(nowInMillis);

		final String year = String.valueOf(now.getYear());
		Assert.assertTrue(dateAsString.startsWith(year));

		final String month = String.valueOf(now.getMonthOfYear());
		Assert.assertTrue(dateAsString.contains(month));

		final String day = String.valueOf(now.getDayOfMonth());
		Assert.assertTrue(dateAsString.contains(day));


		final String dateTimeAsString = DateTimeUtils.fromMillisToDateTimeAsString(nowInMillis);
		Assert.assertTrue(dateTimeAsString.startsWith(dateAsString));
	}

	@Test
	public void validateLocalDate() {
		final LocalDate localDate = DateTimeUtils.today();
		final long systemMillis = System.currentTimeMillis();
		final long nowInMillis = DateTimeUtils.getMillis(localDate);
		final long diffInMillis = nowInMillis - systemMillis;
		Assert.assertTrue(diffInMillis <= ONE_MIN_IN_MILLIS);
		Assert.assertEquals(0, DateTimeUtils.daysBetweenToday(localDate));
	}

}
