package edu.ncsu.csc316.security_manager.io;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.security_manager.list.ArrayBasedList;
import edu.ncsu.csc316.security_manager.log.LogEntry;

/**
 * Testing class for the LogFileReader.
 * @author Nicholas Board (ndboard)
 */
public class LogFileReaderTest {

	/** Filepath of the testing logfile. */
	String logfile = "input/sample-log.txt";
	
	/**
	 * Tests the functionality of the LogFileReader.
	 */
	@Test
	public void testLogFileReader() {
		
		LogFileReader logReader = new LogFileReader(logfile);
		
		ArrayBasedList<LogEntry> data = logReader.getData();
		
		assertEquals(20, data.size() );
		
		try {
			logReader = new LogFileReader("bologna");
			fail();
		} catch (RuntimeException e) {
			assertEquals(20, data.size());
		}
		
		LogEntry testLog = data.get(19);
		assertEquals("6-16-2013 24:28:33", testLog.getTimeStamp().getString());
		assertEquals("user3", testLog.getUsername());
		assertEquals("add appointment requests", testLog.getAction());
	}
}
