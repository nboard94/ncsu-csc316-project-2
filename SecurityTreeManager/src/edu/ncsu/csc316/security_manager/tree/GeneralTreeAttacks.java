package edu.ncsu.csc316.security_manager.tree;

import edu.ncsu.csc316.security_manager.attack.AttackStep;
import edu.ncsu.csc316.security_manager.list.ArrayBasedList;

public class GeneralTreeAttacks {

	public class Node {
		
		AttackStep data;
		Node parent;
		ArrayBasedList<AttackStep> children;
		
		Node( AttackStep newData ) {
			data = newData;
		}
	}
	
	Node head = null;
	
	/**
	 * Constructs a GeneralTree without initializing a head.
	 */
	public GeneralTreeAttacks() {
		
	}
	
	/**
	 * Constructs a GeneralTree and sets the head.
	 * @param headData data for the head node.
	 */
	public GeneralTreeAttacks( AttackStep headData ) {
		
		head = new Node( headData );
	}
	
	
}
