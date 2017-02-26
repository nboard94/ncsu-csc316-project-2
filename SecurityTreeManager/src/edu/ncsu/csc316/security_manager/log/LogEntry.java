package edu.ncsu.csc316.security_manager.log;

/**
 * This class represents the information contained in a
 * node of an log tree.
 * @author Nicholas Board (ndboard)
 */
public class LogEntry {

	/** The log entry's corresponding timeStamp. */
	String timeStamp;
	/** The log entry's corresponding username. */
	String username;
	/** The log entry's corresponding action. */
	String action;
	
	/**
	 * @param newTimeStampString Represents the information for setting the timeStamp of the new LogEntry.
	 * @param newUsername The username of the new LogEntry.
	 * @param newAction The action of the new LogEntry.
	 */
	public LogEntry( String newTimeStampString, String newUsername, String newAction ) {
		
		this.setTimeStamp( newTimeStampString );
		this.setUsername( newUsername );
		this.setAction( newAction );
	}

	/**
	 * Getter method for the LogEntry's timeStamp.
	 * @return the timeStamp.
	 */
	public String getTimeStamp() {
		return timeStamp;
	}

	/**
	 * Setter method for the LogEntry's timeStamp.
	 * @param timeStamp the timeStamp to set.
	 */
	private void setTimeStamp(String timeStamp) {
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
}
