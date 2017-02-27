package edu.ncsu.csc316.security_manager.io;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.security_manager.attack.AttackStep;
import edu.ncsu.csc316.security_manager.attack.AttackType;
import edu.ncsu.csc316.security_manager.list.ArrayBasedList;

/**
 * Tests the  construction and functionalit of the
 * AttackFileReader class.
 * @author Nicholas Board (ndboard)
 */
public class AttackFileReaderTest {

	/** Filepaths of the testing attack file. */
	String attackfilePre = "input/ddos-preorder.txt";
	String attackfilePost = "input/ddos-postorder.txt";
	
	/**
	 * Tests the AttackFileReader given a preorder data file.
	 */
//	@Test
//	public void testAttackFileReaderPre() {
//		
//		AttackFileReader preReader = new AttackFileReader(attackfilePre);
//		
//		ArrayBasedList<AttackStep> data = preReader.getData();
//		
//		assertEquals(15, data.size());
//		
//		try {
//			preReader = new AttackFileReader("bologna");
//			fail();
//		} catch (RuntimeException e) {
//			assertEquals(15, data.size());
//			
//			AttackStep testGoal = data.get(0);
//			assertEquals(AttackType.ATTACKGOAL, testGoal.getType());
//			assertEquals("Use DDoS Attack to Disrupt All Users", testGoal.getDescription());
//			
//			AttackStep testSub = data.get(1);
//			assertEquals(AttackType.SUBGOAL_OR, testSub.getType());
//			assertEquals("Attack Servers", testSub.getDescription());
//			
//			AttackStep testNode = data.get(3);
//			assertEquals(AttackType.LEAF_OR, testNode.getType());
//			assertEquals(0, (int)testNode.getProbability());
//			assertEquals(6, (int)testNode.getImpact());
//			assertEquals(5000, (int)testNode.getCost());
//			assertEquals("\"Rent\" Existing BOTNET", testNode.getDescription());
//			
//		}
//	}
	
	/**
	 * Tests the AttackFileReader given a postorder data file.
	 */
	@Test
	public void testAttackFileReaderPost() {
		
		AttackFileReader postReader = new AttackFileReader(attackfilePost);
		
		ArrayBasedList<AttackStep> data = postReader.getData();
		
		assertEquals(15, data.size());
		
		try {
			postReader = new AttackFileReader("bologna");
			fail();
		} catch (RuntimeException e) {
			assertEquals(15, data.size());
			
			AttackStep testGoal = data.get(14);
			assertEquals(AttackType.ATTACKGOAL, testGoal.getType());
			assertEquals("Use DDoS Attack to Disrupt All Users", testGoal.getDescription());
			
			AttackStep testSub = data.get(7);
			assertEquals(AttackType.SUBGOAL_OR, testSub.getType());
			assertEquals("Attack Servers", testSub.getDescription());
			
			AttackStep testNode = data.get(0);
			assertEquals(AttackType.LEAF_OR, testNode.getType());
			assertEquals(0, (int)testNode.getProbability());
			assertEquals(6, (int)testNode.getImpact());
			assertEquals(5000, (int)testNode.getCost());
			assertEquals("\"Rent\" Existing BOTNET", testNode.getDescription());
			
		}
	}
}
