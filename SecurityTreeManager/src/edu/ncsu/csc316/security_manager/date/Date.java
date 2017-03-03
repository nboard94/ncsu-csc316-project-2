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
	/** The string associated with the date. */
	private String toString;
	
	private String dateOnlyString;
	
	/**
	 * Constructor for a Date object that includes both date and time information.
	 * @param dateTimeString The string with the information to set the Date fields.
	 */
 	public Date( String dateTimeString ) {
		
		if (dateTimeString.length() > 10 ) {
			//9-13-2015 2:58:49
			this.setString(dateTimeString);
			
			String dateString = dateTimeString.substring(0, dateTimeString.indexOf(' '));
			String timeString = dateTimeString.substring(dateTimeString.indexOf(' ') + 1);
			
			this.setDateString(dateString);
			
			String[] dateData = dateString.split("-");
			String[] timeData = timeString.split(":");
			
			char current;
			int startIdx = 0;
			for( int i = 0; i < dateData[0].length(); i++ ) {
				
				current = dateData[0].charAt(i);
				
				if ( !Character.isDigit(current) ) {
					
					startIdx = dateData[0].indexOf(current) + 1;
					dateData[0] = dateData[0].substring(startIdx); 
				}
			}
			
			int newMonth = Integer.valueOf( dateData[0].trim() );
			int newDay = Integer.valueOf( dateData[1].trim() );
			int newYear = Integer.valueOf( dateData[2].trim() );
			int newHour = Integer.valueOf( timeData[0].trim() );
			int newMinute = Integer.valueOf( timeData[1].trim() );
			int newSecond = Integer.valueOf( timeData[2].trim() );
			
			this.setMonth( Integer.valueOf( newMonth ) );
			this.setDay( Integer.valueOf( newDay ) );
			this.setYear( Integer.valueOf( newYear ) );
			
			this.setHour( Integer.valueOf( newHour ) );
			this.setMinute( Integer.valueOf( newMinute ) );
			this.setSecond( Integer.valueOf( newSecond ) );
		}
		else {
			String[] dateData = dateTimeString.split("-");
			
			dateOnlyString = dateTimeString;
			toString = "D.N.A.";
			
			int newMonth = Integer.valueOf( dateData[0].trim() );
			int newDay = Integer.valueOf( dateData[1].trim() );
			int newYear = Integer.valueOf( dateData[2].trim() );
			
			this.setMonth( Integer.valueOf( newMonth ) );
			this.setDay( Integer.valueOf( newDay ) );
			this.setYear( Integer.valueOf( newYear ) );
		}
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
	
	/**
	 * Getter method for the Date's string.
	 * @return the string
	 */
	public String getString() {
		return toString;
	}

	/**
	 * Setter method for the Date's string.
	 * @param newString the string to set
	 */
	public void setString(String newString) {
		this.toString = newString;
	}
	
	/**
	 * Getter method for the Date's string.
	 * @return the string
	 */
	public String getDateString() {
		return this.dateOnlyString;
	}

	/**
	 * Setter method for the Date's string.
	 * @param newString the string to set
	 */
	public void setDateString(String newString) {
		this.dateOnlyString = newString;
	}
	

	/**
	 * Compares Dates using Date and Time.
	 * @param otherDate The date to compare this one to.
	 * @return -1 if this date comes first, 0 if they're the same, 1 if the other is first.
	 */
	public int compareDateTime(Date otherDate) {
		
		if( otherDate.getYear() < this.getYear() ) {
			
			return 1;
		}
		else if( this.getYear() < otherDate.getYear() ) {
		
			return -1;
		}
		else if( this.getYear() == otherDate.getYear() ) {
			
			if( otherDate.getMonth() < this.getMonth() ) {
				
				return 1;
			}
			else if( this.getMonth() < otherDate.getMonth() ) {
			
				return -1;
			}
			else if( this.getMonth() == otherDate.getMonth() ) {
				
				if( otherDate.getDay() < this.getDay() ) {
					
					return 1;
				}
				else if( this.getDay() < otherDate.getDay() ) {
				
					return -1;
				}
				else if( this.getDay() == otherDate.getDay() ) {
					
					if( otherDate.getHour() < this.getHour() ) {
						
						return 1;
					}
					else if( this.getHour() < otherDate.getHour() ) {
					
						return -1;
					}
					else if( this.getHour() == otherDate.getHour() ) {
						
						if( otherDate.getMinute() < this.getMinute() ) {
							
							return 1;
						}
						else if( this.getMinute() < otherDate.getMinute() ) {
						
							return -1;
						}
						else if( this.getMinute() == otherDate.getMinute() ) {
							
							if( otherDate.getSecond() < this.getSecond() ) {
								
								return 1;
							}
							else if( this.getSecond() < otherDate.getSecond() ) {
							
								return -1;
							}
							else if( this.getSecond() == otherDate.getSecond() ) {
								
								return 0;
							}
						}
					}
				}
			}
		}
		
		return 0;
	}
	
	/**
	 * Compares dates using only the date and not the time.
	 * @param otherDate The date to compare this one to.
	 * @return -1 if this date comes first, 0 if they're the same, 1 if the other is first.
	 */
	public int compareDate(Date otherDate) {
		
		if( otherDate.getYear() < this.getYear() ) {
			
			return 1;
		}
		else if( this.getYear() < otherDate.getYear() ) {
		
			return -1;
		}
		else if( this.getYear() == otherDate.getYear() ) {
			
			if( otherDate.getMonth() < this.getMonth() ) {
				
				return 1;
			}
			else if( this.getMonth() < otherDate.getMonth() ) {
			
				return -1;
			}
			else if( this.getMonth() == otherDate.getMonth() ) {
				
				if( otherDate.getDay() < this.getDay() ) {
					
					return 1;
				}
				else if( this.getDay() < otherDate.getDay() ) {
				
					return -1;
				}
				else if( this.getDay() == otherDate.getDay() ) {
					
					return 0;
				}
			}
		}
		
		return 0;
	}
}
