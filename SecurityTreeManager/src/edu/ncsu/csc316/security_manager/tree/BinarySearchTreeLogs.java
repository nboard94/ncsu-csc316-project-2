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
	 * @param newData The initial LogEntry.
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
		
		if ( newData.getTimeStamp().getDateString().length() > 10 ) {
			
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
	
	public LogEntry getData() {
		
		return data;
	}
	
	private void buildByDate( String searchDate ) {
		
		Date toSearch = new Date( searchDate );
		
		if ( searchDate.length() > 10 ) {
			
			if ( toSearch.compareDateTime( this.data.getTimeStamp() ) == 0 && used == false) {
				
				logsByDate.add( this.data );
				this.used = true;
			}
		}
		else {
			
			if ( toSearch.compareDate( this.data.getTimeStamp() ) == 0 && used == false ) {
				
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
	
	public ArrayBasedList<LogEntry> getByDate( String searchDate ) {
		
		this.buildByDate( searchDate );
		return this.logsByDate;
	}
	
	
}
