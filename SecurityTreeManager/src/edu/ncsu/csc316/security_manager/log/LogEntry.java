package edu.ncsu.csc316.security_manager.log;

import edu.ncsu.csc316.security_manager.date.Date;

/**
 * This class represents the information contained in a
 * node of an log tree.
 * @author Nicholas Board (ndboard)
 */
public class LogEntry {

	/** The log entry's corresponding timeStamp. */
	Date timeStamp;
	/** The log entry's corresponding username. */
	String username;
	/** The log entry's corresponding action. */
	String action;
	
	//TODO Need to make use of date objects
	
	/**
	 * Constructor for a LogEntry object.
	 * @param newTimeStampString Represents the information for setting the timeStamp of the new LogEntry.
	 * @param newUsername The username of the new LogEntry.
	 * @param newAction The action of the new LogEntry.
	 */
	public LogEntry( String newTimeStampString, String newUsername, String newAction ) {
		
		Date newDate = new Date(newTimeStampString);
		this.setTimeStamp( newDate );
		this.setUsername( newUsername );
		this.setAction( newAction );
	}

	/**
	 * Getter method for the LogEntry's timeStamp.
	 * @return the timeStamp.
	 */
	public Date getTimeStamp() {
		return timeStamp;
	}

	/**
	 * Setter method for the LogEntry's timeStamp.
	 * @param timeStamp the timeStamp to set.
	 */
	private void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	/**
	 * Getter method for the LogEntry's username.
	 * @return the username.
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Setter method for the LogEntry's username.
	 * @param username the username to set
	 */
	private void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Getter method for the LogEntry's action.
	 * @return the action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * Setter method for the LogEntry's action.
	 * @param action the action to set
	 */
	private void setAction(String action) {
		this.action = action;
	}
	
	/**
	 * Creates a specifically formatted String for the LogEntry.
	 * @return ls.toString() the formatted String.
	 */
	public String logString() {
		
		StringBuilder ls = new StringBuilder();
		
		ls.append( "LogEntry[timestamp=" );
		ls.append( this.getTimeStamp().getYear() + "/" + this.getTimeStamp().getMonth() + "/" + this.getTimeStamp().getDay() + " " );
		ls.append( this.getTimeStamp().getHour() + ":" + this.getTimeStamp().getMinute() + ":" + this.getTimeStamp().getSecond() );
		ls.append( ", user=" + this.getUsername() );
		ls.append( ", description=" + this.getAction() + "]" );
		
		return ls.toString();
	}
}
