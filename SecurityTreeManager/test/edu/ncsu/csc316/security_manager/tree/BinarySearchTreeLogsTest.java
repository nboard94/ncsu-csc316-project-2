package edu.ncsu.csc316.security_manager.tree;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.security_manager.list.ArrayBasedList;
import edu.ncsu.csc316.security_manager.log.LogEntry;

/**
 * Tests the functionality of the Binary Search Tree.
 * @author Nicholas Board (ndboard)
 */
public class BinarySearchTreeLogsTest {

	
	/**
	 * Tests the BST constructor.
	 */
	@Test
	public void testConstructor() {
		
		BinarySearchTreeLogs nullHead = new BinarySearchTreeLogs();
		assertNull(nullHead.getData());
		assertNull(nullHead.getLeftTree());
		assertNull(nullHead.getRightTree());
		
		LogEntry testLog = new LogEntry("11-29-1994", "user", "desc");
		BinarySearchTreeLogs withHead = new BinarySearchTreeLogs( testLog );
		assertEquals(testLog, withHead.getData() );
		assertNull(withHead.getLeftTree());
		assertNull(withHead.getRightTree());
	}
	
	/**
	 * Tests the BST's adding method.
	 */
	@Test
	public void testAdding() {
		
		LogEntry head = new LogEntry("11-29-1994", "user", "desc");
		
		LogEntry left = new LogEntry("11-29-1990", "user", "desc");
		LogEntry leftLeft = new LogEntry("11-29-1980", "user", "desc");
		LogEntry leftRight = new LogEntry("11-29-1992", "user", "desc");
		
		LogEntry right = new LogEntry("11-29-2000", "user", "desc");
		LogEntry rightLeft = new LogEntry("11-29-1997", "user", "desc");
		LogEntry rightRight = new LogEntry("11-29-2017", "user", "desc");
		
		BinarySearchTreeLogs tree = new BinarySearchTreeLogs( );
		
		tree.addNode(head);
		tree.addNode(left);
		tree.addNode(leftLeft);
		tree.addNode(leftRight);
		tree.addNode(right);
		tree.addNode(rightLeft);
		tree.addNode(rightRight);
		
		assertEquals(head.getTimeStamp().getYear(), tree.getData().getTimeStamp().getYear());
		
		assertEquals(left.getTimeStamp().getYear(), tree.getLeftTree().getData().getTimeStamp().getYear());
		assertEquals(leftLeft.getTimeStamp().getYear(), tree.getLeftTree().getLeftTree().getData().getTimeStamp().getYear());
		assertEquals(leftRight.getTimeStamp().getYear(), tree.getLeftTree().getRightTree().getData().getTimeStamp().getYear());
		
		assertEquals(right.getTimeStamp().getYear(), tree.getRightTree().getData().getTimeStamp().getYear());
		assertEquals(rightLeft.getTimeStamp().getYear(), tree.getRightTree().getLeftTree().getData().getTimeStamp().getYear());
		assertEquals(rightRight.getTimeStamp().getYear(), tree.getRightTree().getRightTree().getData().getTimeStamp().getYear());
	}
	
	/**
	 * Tests the BST's getByDate method.
	 */
	@Test
	public void testGetByDate() {
		
		LogEntry head = new LogEntry("11-29-1994 14:42:00", "user", "desc");
		
		LogEntry left = new LogEntry("11-29-1990", "user", "desc");
		LogEntry leftLeft = new LogEntry("11-29-1980", "user", "desc");
		LogEntry leftRight = new LogEntry("11-29-1992", "user", "desc");
		
		LogEntry right = new LogEntry("11-29-2000", "user", "desc");
		LogEntry rightLeft = new LogEntry("11-29-1997", "user", "desc");
		LogEntry rightRight = new LogEntry("11-29-2017", "user", "desc");
		
		BinarySearchTreeLogs tree = new BinarySearchTreeLogs( );
		
		tree.addNode(head);
		tree.addNode(left);
		tree.addNode(leftLeft);
		tree.addNode(leftRight);
		tree.addNode(right);
		tree.addNode(rightLeft);
		tree.addNode(rightRight);
		
		ArrayBasedList<LogEntry> testList = tree.getByDate("11-29-2000");
		
		assertEquals("11-29-2000", testList.get(0).getTimeStamp().getDateString());
	}
}
