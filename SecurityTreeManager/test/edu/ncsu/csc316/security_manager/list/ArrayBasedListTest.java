package edu.ncsu.csc316.security_manager.list;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.security_manager.attack.AttackStep;
import edu.ncsu.csc316.security_manager.log.LogEntry;

/**
 * Tests the ArrayBasedList data structure.
 * @author Nicholas Board (ndboard)
 */
public class ArrayBasedListTest {

	/** The ArrayBasedList to use when testing. */
	ArrayBasedList<Object> smallList;
	/** A LogEntry object to use when testing. */
	LogEntry testLog;
	/** An AttackStep object to use when testing. */
	AttackStep testStep;
	
	/**
	 * Tests the constructor of the ArrayBasedList.
	 */
	@Before
	public void testArrayBastList() {
		smallList = new ArrayBasedList<Object>();
		testLog = new LogEntry("11-29-1994 14:42:00", "testName", "testState");
		testStep = new AttackStep("GOAL", "testDesc");
		
	}
	
	/**
	 * Tests the size getter for ArrayBasedList.
	 */
	@Test
	public void testSize() {
		assertEquals(0, smallList.size());
	}
	
	/**
	 * Tests adding objects to the ArrayBasedList.
	 */
	@Test
	public void addTest() {
	    smallList.add(testLog);
	    
	    assertEquals(1, smallList.size());
	    assertEquals(testLog, smallList.get(0));
	    
	    smallList.add(testStep);
	    assertEquals(2, smallList.size());
	    assertEquals(testStep, smallList.get(1));
	    
	    smallList.add(testLog);
	    smallList.add(testLog);
	    smallList.add(testLog);
	    smallList.add(testLog);
	    smallList.add(testLog);
	    smallList.add(testLog);
	    smallList.add(testLog);
	    smallList.add(testLog);
	    smallList.add(testLog);
	    
	    assertEquals(11, smallList.size());
	}
	
	/**
	 * Tests the swap method in ArrayBasedList.
	 */
	@Test
	public void swapTest() {
		ArrayBasedList<LogEntry> list = new ArrayBasedList<LogEntry>();
		
		LogEntry log1 = new LogEntry("11-29-1994 14:42:00", "user1", "desk1");
		LogEntry log2 = new LogEntry("11-29-1994 14:42:00", "user2", "desk2");
		
		list.add(log1);
		list.add(log2);
		
		assertEquals(log1, list.get(0));
		assertEquals(log2, list.get(1)); 
		
		list.swap(0, 1);
		
		assertEquals(log2, list.get(0));
		assertEquals(log1, list.get(1));
	}
}
