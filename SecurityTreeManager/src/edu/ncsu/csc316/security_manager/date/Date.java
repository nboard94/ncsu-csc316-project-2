package edu.ncsu.csc316.security_manager.date;

/**
 * Custom Date class to represent Date objects.
 * @author Nicholas Board (ndboard)
 */
public class Date {

	/** The date's corresponding year. */
	private int year;
	/** The date's corresponding month. */
	private int month;
	/** The date's corresponding day. */
	private int day;
	/** The date's corresponding hour. */
	private int hour;
	/** The date's corresponding minute. */
	private int minute;
	/** The date's corresponding second. */
	private int second;
	
	/**
	 * Constructor for a Date object that includes both date and time information.
	 * @param newYear The year to set.
	 * @param newMonth The month to set.
	 * @param newDay The day to set.
	 * @param newHour The hour to set.
	 * @param newMinute The minute to set.
	 * @param newSecond The second to set.
	 */
	public Date( int newYear, int newMonth, int newDay, int newHour, int newMinute, int newSecond ) {
		
		this.setYear( newYear );
		this.setMonth( newMonth );
		this.setDay( newDay );
		this.setHour( newHour );
		this.setMinute( newMinute );
		this.setSecond( newSecond );
	}
	
	/**
	 * Constructor for a Date object that includes only date information.
	 * @param newYear The year to set.
	 * @param newMonth The month to set.
	 * @param newDay The day to set.
	 */
	public Date( int newYear, int newMonth, int newDay ) {
		
		this.setYear( newYear );
		this.setMonth( newMonth );
		this.setDay( newDay );
	}

	/**
	 * Getter method for the Date's year.
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Setter method for the Date's year.
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * Getter method for the Date's month.
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * Setter method for the Date's month.
	 * @param month the month to set
	 */
	public void setMonth(int month) {
		this.month = month;
	}

	/**
	 * Getter method for the Date's day.
	 * @return the day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * Setter method for the Date's day.
	 * @param day the day to set
	 */
	public void setDay(int day) {
		this.day = day;
	}

	/**
	 * Getter method for the Date's hour.
	 * @return the hour
	 */
	public int getHour() {
		return hour;
	}

	/**
	 * Setter method for the Date's hour.
	 * @param hour the hour to set
	 */
	public void setHour(int hour) {
		this.hour = hour;
	}

	/**
	 * Getter method for the Date's minute.
	 * @return the minute
	 */
	public int getMinute() {
		return minute;
	}

	/**
	 * Setter method for the Date's minute.
	 * @param minute the minute to set
	 */
	public void setMinute(int minute) {
		this.minute = minute;
	}

	/**
	 * Getter method for the Date's second.
	 * @return the second
	 */
	public int getSecond() {
		return second;
	}

	/**
	 * Setter method for the Date's second.
	 * @param second the second to set
	 */
	public void setSecond(int second) {
		this.second = second;
	}
}
