package edu.ncsu.csc316.security_manager.date;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the functionality of the Date class.
 * @author Nicholas Board (ndboard)
 */
public class DateTest {

	/**
	 * Tests constructing and getting from a Date object that
	 * contains both date and time information.
	 */
	@Test
	public void dateAndTimeTest() {
		
		Date justDate = new Date("11-29-1994 14:42:00");
		
		assertEquals( 1994, justDate.getYear() );
		assertEquals( 11, justDate.getMonth() );
		assertEquals( 29, justDate.getDay() );
		assertEquals( 14, justDate.getHour() );
		assertEquals( 42, justDate.getMinute() );
		assertEquals( 0, justDate.getSecond() );
		assertEquals( "11-29-1994 14:42:00", justDate.getString());
	}
	
	@Test
	public void compareDateTest() {
		
		Date td;
		Date od;
		
		//otherDate's year is first
		td = new Date("11-29-1994 14:42:02");
		od = new Date("11-29-1990 14:42:02");
		assertEquals( 1, td.compareDate(od));
		
		//thisDate's year is first
		td = new Date("11-29-1894 14:42:02");
		assertEquals( -1, td.compareDate(od));
		
		//otherDate's month is first
		od = new Date("08-29-1894 14:42:02");
		assertEquals( 1, td.compareDate(od));
		
		//thisDate's month is first
		td = new Date("01-29-1894 14:42:02");
		assertEquals( -1, td.compareDate(od));
		
		//otherDate's day is first
		od = new Date("01-14-1894 14:42:02");
		assertEquals( 1, td.compareDate(od));
		
		//thisDate's day is first
		td = new Date("01-02-1894 14:42:02");
		assertEquals( -1, td.compareDate(od));
		
		//otherDate's hour is first
		od = new Date("01-02-1894 03:42:02");
		assertEquals( 1, td.compareDate(od));
		
		//thisDate's hour is first
		td = new Date("01-02-1894 01:42:02");
		assertEquals( -1, td.compareDate(od));
		
		//otherDate's minute is first
		od = new Date("01-02-1894 01:12:02");
		assertEquals( 1, td.compareDate(od));
		
		//thisDate's minute is first
		td = new Date("01-02-1894 01:06:02");
		assertEquals( -1, td.compareDate(od));
		
		//otherDate's second is first
		od = new Date("01-02-1894 01:06:01");
		assertEquals( 1, td.compareDate(od));
				
		//thisDate's second is first
		td = new Date("01-02-1894 01:06:00");
		assertEquals( -1, td.compareDate(od));
		
		//dates are the same
		od = new Date("01-02-1894 01:06:00");
		assertEquals( 0, td.compareDate(od));
		assertEquals( 0, od.compareDate(td));

	}
}
