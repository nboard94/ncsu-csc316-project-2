package edu.ncsu.csc316.security_manager.tree;

import edu.ncsu.csc316.security_manager.list.ArrayBasedList;
import edu.ncsu.csc316.security_manager.log.LogEntry;

/**
 * This is a Binary Search Tree algorithm
 * @author Nicholas Board (ndboard)
 */
public class BinarySearchTreeLogs {

	private LogEntry data;
	private BinarySearchTreeLogs leftSubTree;
	private BinarySearchTreeLogs rightSubTree;
	ArrayBasedList<LogEntry> logsInDate = new ArrayBasedList<LogEntry>();
	
	/**
	 * Constructor for a BST with LogEntries.
	 * @param newData The initial LogEntry.
	 */
	public BinarySearchTreeLogs(LogEntry newData) {
		
		this.data = newData;
		this.leftSubTree = null;
		this.rightSubTree = null;
	}
	
	/**
	 * Adds a LogEntry node to the BST.
	 * @param newData the new LogEntry to be added.
	 */
	public void addNode(LogEntry newData) {
		
		if ( this.data.getTimeStamp().compareDate( newData.getTimeStamp() ) == 1 ) {
		
			if ( this.leftSubTree != null) {
				
				this.leftSubTree.addNode( newData );
			}
			else {
				
				this.leftSubTree = new BinarySearchTreeLogs( newData );
			}
		}
		else {
			
			if ( this.rightSubTree != null ) {
				
				this.rightSubTree.addNode( newData );
			}
			else {
				
				this.rightSubTree = new BinarySearchTreeLogs( newData );
			}
		}
		
	}
	

	
	/**
	 * Getter for the leftSubTree.
	 * @return The subtree left relative to this node.
	 */
	public BinarySearchTreeLogs getLeftTree() {
		
		return this.leftSubTree;
	}
	
	/**
	 * Getter for the rightSubTree.
	 * @return The subtree right relative to this node.
	 */
	public BinarySearchTreeLogs getRightTree() {
		
		return this.rightSubTree;
	}
	
	public LogEntry getData() {
		
		return data;
	}
	
	
}
