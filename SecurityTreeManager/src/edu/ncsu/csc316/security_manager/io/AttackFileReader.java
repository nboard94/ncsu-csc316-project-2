package edu.ncsu.csc316.security_manager.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import edu.ncsu.csc316.security_manager.attack.AttackStep;
import edu.ncsu.csc316.security_manager.list.ArrayBasedList;

/**
 * Class to read in data from an attack file. 
 * Preorder or postorder.
 * @author Nicholas Board (ndboard)
 */
public class AttackFileReader {

	private ArrayBasedList<AttackStep> data = new ArrayBasedList<AttackStep>();
	private String currentLine;
	private String[] currentData;
	
	private String currentRelation;
	private String currentDescription;
	private double currentProbability;
	private double currentImpact;
	private double currentCost;
	
	/**
	 * Scans in a file, adding AttackStep data to the ArrayBasedList.
	 * @param filepath The path to the attack file.
	 */
	public AttackFileReader(String filepath) {
		
		File file = new File(filepath);
		Scanner scan;
		StringBuilder sb = new StringBuilder();
		
		try {
			scan = new Scanner(file, "UTF8");
		} catch (FileNotFoundException e) {
			throw new RuntimeException();
		}
		
		AttackStep currentAttack;
		while (scan.hasNextLine()) {
			
			currentLine = scan.nextLine();
			currentData = currentLine.split(" ");
			sb.delete(0, sb.length());
			
			currentRelation = currentData[0].trim();
			if(currentRelation.length() != 4 && currentRelation.contains("A")) {
				currentRelation = "A";
			}
			else if(currentRelation.length() != 4 && currentRelation.contains("O")) {
				currentRelation = "O";
			}
				
			
			
			try {
				currentProbability = Double.valueOf(currentData[1]);
				currentImpact = Double.valueOf(currentData[2]);
				currentCost = Double.valueOf(currentData[3]);
				
				for(int i = 4; i < currentData.length; i++) {
					sb.append(currentData[i]);
					sb.append(' ');
				}
				
				currentDescription = sb.toString().trim();
				currentAttack = new AttackStep(	currentRelation,
												currentProbability,
												currentImpact,
												currentCost,
												currentDescription );
			}
			catch (NumberFormatException e) {
				
				for(int i = 1; i < currentData.length; i++) {
					
					sb.append(currentData[i]);
					sb.append(' ');
				}
				
				currentDescription = sb.toString().trim();
				currentAttack = new AttackStep(currentRelation, currentDescription);
			}
			
			data.add(currentAttack);
		}
		
		scan.close();
	}
	
	/**
	 * Getter method for the data.
	 * @return data The AttackStep data in an ArrayBasedList.
	 */
	public ArrayBasedList<AttackStep> getData() {
		return data;
	}
}
