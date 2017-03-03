package edu.ncsu.csc316.security_manager.tree;

import edu.ncsu.csc316.security_manager.date.Date;
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
	private static ArrayBasedList<LogEntry> logsByDate = new ArrayBasedList<LogEntry>();
	boolean used = false;
	
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
	 * Constructor for a BST.
	 */
	public BinarySearchTreeLogs() {
		
		this.data = null;
		this.leftSubTree = null;
		this.rightSubTree = null;
	}
	
	/**
	 * Adds a LogEntry node to the BST.
	 * @param newData the new LogEntry to be added.
	 */
	public void addNode(LogEntry newData) {
		
		if ( newData.getTimeStamp().getString().length() > 10 ) {
			
			if ( this.data == null ) {
				
				this.data = newData;
			}
			
			else if ( newData.getTimeStamp().compareDateTime( this.data.getTimeStamp() ) == -1 ) {
				
				if ( this.leftSubTree == null ) {
					
					this.leftSubTree = new BinarySearchTreeLogs( newData );
				}
				
				else {
					
					this.leftSubTree.addNode( newData );
				}
			}
			
			else {
				
				if ( this.rightSubTree == null ) {
					
					this.rightSubTree = new BinarySearchTreeLogs( newData );
				}
				
				else {
					
					this.rightSubTree.addNode( newData );
				}
			}
		}
		
		else {
			
			if ( this.data == null ) {
				
				this.data = newData;
			}
			
			else if ( newData.getTimeStamp().compareDate( this.data.getTimeStamp() ) == -1 ) {
				
				if ( this.leftSubTree == null ) {
					
					this.leftSubTree = new BinarySearchTreeLogs( newData );
				}
				
				else {
					
					this.leftSubTree.addNode( newData );
				}
			}
			
			else {
				
				if ( this.rightSubTree == null ) {
					
					this.rightSubTree = new BinarySearchTreeLogs( newData );
				}
				
				else {
					
					this.rightSubTree.addNode( newData );
				}
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
	
	/**
	 * Gets the data associated with this node.
	 * @return data The data associated with this node in the tree.
	 */
	public LogEntry getData() {
		
		return data;
	}
	
	/**
	 * Traverses the array and adds nodes with corresponding dates.
	 * @param searchDate The date to compare to.
	 */
	private void buildByDate( String searchDate ) {
		
		Date toSearch = new Date( searchDate );
		
		if ( searchDate.length() > 11 ) {
			
			if ( toSearch.getYear() == this.data.getTimeStamp().getYear() &&
					toSearch.getMonth() == this.data.getTimeStamp().getMonth() && 
					toSearch.getDay() == this.data.getTimeStamp().getDay() &&
					toSearch.getHour() == this.data.getTimeStamp().getHour() &&
					toSearch.getMinute() == this.data.getTimeStamp().getMinute() &&
					toSearch.getSecond() == this.data.getTimeStamp().getSecond() ) {
				
				logsByDate.add( this.data );
				this.used = true;
			}
		}
		else {
			
			if ( toSearch.getYear() == this.data.getTimeStamp().getYear() &&
					toSearch.getMonth() == this.data.getTimeStamp().getMonth() && 
					toSearch.getDay() == this.data.getTimeStamp().getDay()) {
				
				logsByDate.add( this.data );
				this.used = true;
			}
		}
		
		if ( this.leftSubTree != null ) {
			
			this.leftSubTree.buildByDate( searchDate );
		}
		
		if ( this.rightSubTree != null ) {
			
			 this.rightSubTree.buildByDate( searchDate );
		}
		
	}
	
	/**
	 * Returns an array containing logs corresponding to a specific date.
	 * @param searchDate The date to search for logs with.
	 * @return logsByDate Contains logs corresponding to a specific date.
	 */
	public ArrayBasedList<LogEntry> getByDate( String searchDate ) {
		
		this.buildByDate( searchDate );
		return BinarySearchTreeLogs.logsByDate;
	}
	
	
}
