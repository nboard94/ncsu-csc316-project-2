package edu.ncsu.csc316.security_manager.attack;

/**
 * An enumerated type that describes the different kinds of
 * nodes in the attack tree.
 * @author Nicholas Board (ndboard)
 */
public enum AttackType {
	
	/** Represents the head of the attack tree. */
	ATTACKGOAL,
	/** Represents a sub node on the attack tree with an AND relationship. */
	SUBGOAL_AND,
	/** Represents a sub node on the attack tree with an OR relationship. */
	SUBGOAL_OR,
	/** Represents a leaf on the attack tree with an AND relationship.  */
	LEAF_AND,
	/** Represents a leaf on the attack tree with an OR relationship. */
	LEAF_OR
}
