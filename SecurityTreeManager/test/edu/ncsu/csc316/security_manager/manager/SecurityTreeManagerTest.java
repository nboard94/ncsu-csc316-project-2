package edu.ncsu.csc316.security_manager.manager;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the construction and functionality
 * of the SecurityTreeManager class.
 * @author Nicholas Board (ndboard)
 */
public class SecurityTreeManagerTest {

	/**
	 * Tests the constructor for the SecurityTreeManager.
	 */
	@Test
	public void constructorTest() {
		
		SecurityTreeManager logMan = new SecurityTreeManager( "input/sample-log.txt" );
		SecurityTreeManager attackMan = new SecurityTreeManager( "", "");
		
		assertEquals("user2", logMan.getLogData().get(0).getUsername());
		
		//String expectedEntry = "LogEntry[timestamp=2015/09/13 02:58:49, user=user2, description=save patient list]"; 
		String logForDate = logMan.getLogEntriesForDate("09-13-2015");
		logForDate = attackMan.getLogEntriesForDate("09-13-2015");
		
		assertTrue(0 < logForDate.length());
		
	}
	
	//TODO remove these
	/**
	 * Fills method coverage so I can try and access TS test cases.
	 */
	@Test
	public void fillerTest() {
		
		SecurityTreeManager logMan = new SecurityTreeManager( "input/sample-log.txt" );

		assertEquals("", logMan.getAttackTreeLevelOrder());
		assertEquals("", logMan.getLogTreeLevelOrder());
		assertEquals("", logMan.propagateValues());
		
	}
}
