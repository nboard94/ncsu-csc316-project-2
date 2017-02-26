package edu.ncsu.csc316.security_manager.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.ncsu.csc316.security_manager.attack.AttackStep;
import edu.ncsu.csc316.security_manager.list.ArrayBasedList;

public class AttackFileReader {

	private ArrayBasedList<AttackStep> data = new ArrayBasedList<AttackStep>();
	private String currentLine;
	
	private String currentRelation;
	private String currentDescription;
	private double currentProbability;
	private double currentImpact;
	private double currentCost;
	
	public AttackFileReader(String filepath) {
		
		File file = new File(filepath);
		Scanner scan;
		
		try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("Invalid AttackStep filepath");
			throw new RuntimeException();
		}
		
		AttackStep currentAttack;
		currentLine = scan.nextLine();
		currentRelation = currentLine.substring(0, 4);
		currentDescription = currentLine.substring(5);
		currentDescription.trim();
		
		currentAttack = new AttackStep( currentRelation, currentDescription );
		data.add(currentAttack);
		
		while (scan.hasNextLine()) {
		
			currentAttack = new AttackStep( "", "" );
			currentLine = scan.nextLine();
			
			currentRelation = currentLine.substring(0, currentLine.indexOf(' '));
			
			
			
		
	
		}
		
		scan.close();
	}
}
