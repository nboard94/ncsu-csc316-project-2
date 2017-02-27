package edu.ncsu.csc316.security_manager.log;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test the construction and methods of the LogEntry class.
 * @author Nicholas Board (ndboard)
 */
public class LogEntryTest {

	/**
	 * Tests the construction of a LogEntry object.
	 */
	@Test
	public void testLogEntry() {
		
		LogEntry log = new LogEntry("02-25-2017 15:53:00" , "ndboard", "working hard on project");
		
		assertEquals( "02-25-2017 15:53:00", log.getTimeStamp() );	
		assertEquals( "ndboard", log.getUsername() );
		assertEquals( "working hard on project", log.getAction() );
	}
}
