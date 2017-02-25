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
		
		Date justDate = new Date( 1994, 11, 29, 14, 42, 0 );
		
		assertEquals( 1994, justDate.getYear() );
		assertEquals( 11, justDate.getMonth() );
		assertEquals( 29, justDate.getDay() );
		assertEquals( 14, justDate.getHour() );
		assertEquals( 42, justDate.getMinute() );
		assertEquals( 0, justDate.getSecond() );
	}
	
	/**
	 * Tests constructing and getting from a Date object that
	 * contains only date information.
	 */
	@Test
	public void justDateTest() {
		Date dateTime = new Date( 2013, 8, 11 );
		
		assertEquals( 2013, dateTime.getYear() );
		assertEquals( 8, dateTime.getMonth() );
		assertEquals( 11, dateTime.getDay() );
	}
}
