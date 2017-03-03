package edu.ncsu.csc316.security_manager.tree;

import edu.ncsu.csc316.security_manager.attack.AttackStep;
import edu.ncsu.csc316.security_manager.list.ArrayBasedList;

/**
 * A General Tree class used to store AttackSteps.
 * @author Nicholas Board (ndboard)
 */
public class GeneralTreeAttacks {

	/**
	 * Inner class representing Node objects in the GeneralTree.
	 * @author Nicholas Board (ndboard)
	 */
	public class Node {
		
		AttackStep data;
		Node parent;
		ArrayBasedList<AttackStep> children;
		
		/**
		 * Constructor for a Node object.
		 * @param newData Data to insert in the new node.
		 */
		Node( AttackStep newData ) {
			data = newData;
		}
	}
	
	Node head;
	int nothing;
	
	/**
	 * Constructs a GeneralTree without initializing a head.
	 */
	public GeneralTreeAttacks() {
		Node head = null;
		
		if (head == null )
			nothing++;
	}
	
	/**
	 * Constructs a GeneralTree and sets the head.
	 * @param headData data for the head node.
	 */
	public GeneralTreeAttacks( AttackStep headData ) {
		
		head = new Node( headData );
	}
	
	
}
