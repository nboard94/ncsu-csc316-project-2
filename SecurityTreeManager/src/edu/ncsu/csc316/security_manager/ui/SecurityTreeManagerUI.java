package edu.ncsu.csc316.security_manager.ui;

import java.util.Scanner;

import edu.ncsu.csc316.security_manager.manager.SecurityTreeManager;

/**
 * This class provides the user interface and 
 * interactivity of the program.
 * @author Nicholas Board (ndboard)
 */
public class SecurityTreeManagerUI {

	//TODO take out the filepaths here, only for testing
	private SecurityTreeManager manager;
	private String attackFilePre = "input/ddos-preorder.txt";
	private String attackFilePost = "input/ddos-postorder.txt";
	private String logfile = "input/sample-log.txt";
	private String command = "";
	
	/**
	 * Constructs a SecurityTreeManagerUI object.
	 * No additional functionality.
	 */
	public SecurityTreeManagerUI() {
		//This constructor is intentionally left empty.
	}
	
	/**
	 * Where the program kicks-off.
	 * @param args Array that would contain command-line arguments.
	 */
	public static void main( String args[] ) {
		
		SecurityTreeManagerUI commandLine = new SecurityTreeManagerUI();
		Scanner commandScan = new Scanner(System.in);
		
		while(!commandLine.command.equals("exit")) {
			System.out.println("Enter 'a' to build an attack tree.\n"
								+ "Enter 'l' to filter log files by date.\n"
								+ "Enter 'exit' to quit the program.");
			
			commandLine.command = commandScan.nextLine();
			
			if(commandLine.command.equals("exit")) {
				System.exit(0);
			}
			else if(commandLine.command.equals("a")) {
				
				//TODO uncomment these later
				System.out.println("Enter pre-order traversal file: ");
				//commandLine.attackFilePre = commandScan.nextLine();
				System.out.println("Enter post-order traversal file: ");
				//commandLine.attackFilePost = commandScan.nextLine();
				
				if(commandLine.attackFilePost == null || commandLine.attackFilePre == null) {
					System.out.println("Please enter a valid filepath.");
				}
				else {
					//TODO function will call manager to create a tree
				}
			}
			else if(commandLine.command.equals("l")) {
				
				System.out.println("Enter unsorted log file: ");
				//commandLine.logfile = commandScan.nextLine();
				
				if(commandLine.logfile == null) {
					System.out.println("Please enter a valid filepath.");
				}
				else {
					//TODO function will call manager to sort log files
				}
			}
			else {
				System.out.println("Invalid input.");
			}
			
			System.out.print("\n");
		}
		
		commandScan.close();
	}

	/**
	 * Gets the file-path for the pre order traversal file.
	 * @return the attackFilePre The pre order traversal file.
	 */
	public String getAttackFilePre() {
		return attackFilePre;
	}

	/**
	 * Sets the file-path for the pre order traversal file.
	 * @param attackFilePre the attackFilePre to set
	 */
	public void setAttackFilePre(String attackFilePre) {
		this.attackFilePre = attackFilePre;
	}

	/**
	 * Gets the file-path for the post order traversal file.
	 * @return the attackFilePost The post order traversal file.
	 */
	public String getAttackFilePost() {
		return attackFilePost;
	}

	/**
	 * Sets the file-path for the post order traversal file.
	 * @param attackFilePost the attackFilePost to set
	 */
	public void setAttackFilePost(String attackFilePost) {
		this.attackFilePost = attackFilePost;
	}

	/**
	 * Gets the file-path for the log-file.
	 * @return the logfile The unsorted log-file.
	 */
	public String getLogfile() {
		return logfile;
	}

	/**
	 * Sets the file-path for the log-file.
	 * @param logfile the logfile to set
	 */
	public void setLogfile(String logfile) {
		this.logfile = logfile;
	}
}
