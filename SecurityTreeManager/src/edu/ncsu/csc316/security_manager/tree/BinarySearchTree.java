package edu.ncsu.csc316.security_manager.tree;

import edu.ncsu.csc316.security_manager.list.ArrayBasedList;
import edu.ncsu.csc316.security_manager.log.LogEntry;

/**
 * This is a Binary Search Tree algorithm
 * @author Nicholas Board (ndboard)
 */
public class BinarySearchTree {

	private LogEntry data;
	private BinarySearchTree leftSubTree;
	private BinarySearchTree rightSubTree;
	ArrayBasedList<LogEntry> logsInDate = new ArrayBasedList<LogEntry>();
	
	/**
	 * Constructor for a BST with LogEntries.
	 * @param newData The initial LogEntry.
	 */
	public BinarySearchTree(LogEntry newData) {
		
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
				
				this.leftSubTree = new BinarySearchTree( newData );
			}
		}
		else {
			
			if ( this.rightSubTree != null ) {
				
				this.rightSubTree.addNode( newData );
			}
			else {
				
				this.rightSubTree = new BinarySearchTree( newData );
			}
		}
		
	}
	

	
	/**
	 * Getter for the leftSubTree.
	 * @return The subtree left relative to this node.
	 */
	public BinarySearchTree getLeftTree() {
		
		return this.leftSubTree;
	}
	
	/**
	 * Getter for the rightSubTree.
	 * @return The subtree right relative to this node.
	 */
	public BinarySearchTree getRightTree() {
		
		return this.rightSubTree;
	}
	
	public LogEntry getData() {
		
		return data;
	}
	
	
}
