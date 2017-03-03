package edu.ncsu.csc316.security_manager.date;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.security_manager.attack.AttackType;

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
	
	/**
	 * Test the compareDateTime method in Date.
	 */
	@Test
	public void compareDateTimeTest() {
		
		Date td;
		Date od;
		
		//otherDate's year is first
		td = new Date("11-29-1994 14:42:02");
		od = new Date("11-29-1990 14:42:02");
		assertEquals( 1, td.compareDateTime(od));
		
		//thisDate's year is first
		td = new Date("11-29-1894 14:42:02");
		assertEquals( -1, td.compareDateTime(od));
		
		//otherDate's month is first
		od = new Date("08-29-1894 14:42:02");
		assertEquals( 1, td.compareDateTime(od));
		
		//thisDate's month is first
		td = new Date("01-29-1894 14:42:02");
		assertEquals( -1, td.compareDateTime(od));
		
		//otherDate's day is first
		od = new Date("01-14-1894 14:42:02");
		assertEquals( 1, td.compareDateTime(od));
		
		//thisDate's day is first
		td = new Date("01-02-1894 14:42:02");
		assertEquals( -1, td.compareDateTime(od));
		
		//otherDate's hour is first
		od = new Date("01-02-1894 03:42:02");
		assertEquals( 1, td.compareDateTime(od));
		
		//thisDate's hour is first
		td = new Date("01-02-1894 01:42:02");
		assertEquals( -1, td.compareDateTime(od));
		
		//otherDate's minute is first
		od = new Date("01-02-1894 01:12:02");
		assertEquals( 1, td.compareDateTime(od));
		
		//thisDate's minute is first
		td = new Date("01-02-1894 01:06:02");
		assertEquals( -1, td.compareDateTime(od));
		
		//otherDate's second is first
		od = new Date("01-02-1894 01:06:01");
		assertEquals( 1, td.compareDateTime(od));
				
		//thisDate's second is first
		td = new Date("01-02-1894 01:06:00");
		assertEquals( -1, td.compareDateTime(od));
		
		//dates are the same
		od = new Date("01-02-1894 01:06:00");
		assertEquals( 0, td.compareDateTime(od));
		assertEquals( 0, od.compareDateTime(td));

	}
	
	/**
	 * Test the compare method in Date.
	 */
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
		
		//they are the same
		od = new Date("01-02-1894 14:42:02");
		assertEquals(0, td.compareDate(od));

	}
	
	/**
	 * Tests the string info methods in Date.
	 */
	@Test
	public void testStrings() {
		
		Date bd = new Date("01-02-1894 14:42:02");
		
		assertEquals("01-02-1894", bd.getDateString());
	}
	
	@Test
	public void testForeignEnum() {
		
		assertEquals(AttackType.valueOf("ATTACKGOAL"), AttackType.ATTACKGOAL);
	}
}
