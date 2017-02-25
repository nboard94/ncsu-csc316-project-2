package edu.ncsu.csc316.security_manager.attack;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the constructors and methods of the AttackStep class.
 * @author Nicholas Board (ndboard)
 */
public class AttackStepTest {

	@Test
	public void attackGoalTest() {
		
		AttackStep attackGoal = new AttackStep( "GOAL", "Finish the project with a good grade." );
		
		assertEquals( AttackType.ATTACKGOAL, attackGoal.getType() );
		assertEquals( "Finish the project with a good grade.", attackGoal.getDescription() );
	}
	
	@Test
	public void subGoalTest() {
		
		AttackStep andSubGoal = new AttackStep( "A", "And this thing." );
		
		assertEquals( AttackType.SUBGOAL_AND, andSubGoal.getType() );
		assertEquals( "And this thing.", andSubGoal.getDescription() );
		
		
		AttackStep orSubGoal = new AttackStep( "O", "Or this thing." );
		
		assertEquals( AttackType.SUBGOAL_OR, orSubGoal.getType() );
		assertEquals( "Or this thing.", orSubGoal.getDescription() );
	}
	
	@Test
	public void leafTest() {
		
		AttackStep andLeafNode = new AttackStep( "A", 5, 4, 35000, "And this leaf." );
		
		assertEquals( AttackType.LEAF_AND, andLeafNode.getType() );
		assertEquals( (int) 5, (int) andLeafNode.getProbability() );
		assertEquals( (int) 4, (int) andLeafNode.getImpact() );
		assertEquals( (int) 35000, (int) andLeafNode.getCost() );
		assertEquals( "And this leaf.", andLeafNode.getDescription() );
		
		
		AttackStep orLeafNode = new AttackStep( "O", 95, 8, 4500, "Or this leaf." );
		
		assertEquals( AttackType.LEAF_OR, orLeafNode.getType() );
		assertEquals( (int) 95, (int) orLeafNode.getProbability() );
		assertEquals( (int) 8, (int) orLeafNode.getImpact() );
		assertEquals( (int) 4500, (int) orLeafNode.getCost() );
		assertEquals( "Or this leaf.", orLeafNode.getDescription() );	
	}
}
