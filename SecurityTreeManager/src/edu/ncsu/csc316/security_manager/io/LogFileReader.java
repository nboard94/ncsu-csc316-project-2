package edu.ncsu.csc316.security_manager.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.ncsu.csc316.security_manager.list.ArrayBasedList;
import edu.ncsu.csc316.security_manager.log.LogEntry;

/**
 * Class to read in the data from a logfile.
 * @author Nicholas Board (ndboard)
 */
public class LogFileReader {

	/** The LogEntry data.  */
	private ArrayBasedList<LogEntry> data = new ArrayBasedList<LogEntry>();
	/** The current line being processed.  */
	private String currentLine;
	/** The data extrated from the currentLine to create a new LogEntry. */
	private String[] currentData;
	
	/**
	 * Scans in a file, adding LogEntry data to the ArrayBasedList.
	 * @param filepath The path to the logfile.
	 */
	public LogFileReader(String filepath) {
		
		File file = new File(filepath);
		Scanner scan;
		try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			throw new RuntimeException();
		}
		
		LogEntry currentLog;
		while(scan.hasNextLine()) {
			
			currentLog = new LogEntry( "", "", "" );
			currentLine = scan.nextLine();
			currentData = currentLine.split(",");
			currentData[0] = currentData[0].trim();
			currentData[1] = currentData[1].trim();
			currentData[2] = currentData[2].trim();
			
			currentLog = new LogEntry(	currentData[0],
										currentData[1],
										currentData[2]);
			
			data.add(currentLog);
		}
		
		scan.close();
	}
	
	/**
	 * Getter method for the data.
	 * @return data The LogEntry data in an ArrayBasedList.
	 */
	public ArrayBasedList<LogEntry> getData() {
		return data;
	}
}
