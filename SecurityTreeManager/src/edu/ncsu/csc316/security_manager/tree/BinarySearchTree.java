package edu.ncsu.csc316.security_manager.tree;

import edu.ncsu.csc316.security_manager.date.Date;
import edu.ncsu.csc316.security_manager.list.ArrayBasedList;
import edu.ncsu.csc316.security_manager.log.LogEntry;

public class BinarySearchTree {

	private LogEntry data;
	private BinarySearchTree leftSubTree;
	private BinarySearchTree rightSubTree;
	ArrayBasedList<String> logsInDate = new ArrayBasedList<String>();
	
	public BinarySearchTree(LogEntry newData) {
		
		this.data = newData;
		this.leftSubTree = null;
		this.rightSubTree = null;
	}
	
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
	
	private void buildLogsByDate( Date searchDate ) {
		
		if ( this.data.getTimeStamp().compareDate(searchDate) == 0 )
			logsInDate.add( this.data.logString() );
		
		if ( this.leftSubTree != null )
			this.leftSubTree.getLogsByDate(searchDate);
		
		if ( this.rightSubTree != null )
			this.rightSubTree.getLogsByDate(searchDate);
	}
	
	public ArrayBasedList<String> getLogsByDate( Date searchDate ) {
		
		this.buildLogsByDate(searchDate);
		return this.logsInDate;
	}
	
	
}
