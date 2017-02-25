package edu.ncsu.csc316.security_manager.attack;

/**
 * An enumerated type that describes the different kinds of
 * nodes in the attack tree.
 * @author Nicholas Board (ndboard)
 */
public enum AttackType {
	
	ATTACKGOAL,
	SUBGOAL_AND,
	SUBGOAL_OR,
	LEAF_AND,
	LEAF_OR
}
