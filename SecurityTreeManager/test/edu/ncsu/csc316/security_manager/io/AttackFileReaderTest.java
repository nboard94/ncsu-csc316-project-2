package edu.ncsu.csc316.security_manager.io;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.security_manager.attack.AttackStep;
import edu.ncsu.csc316.security_manager.attack.AttackType;
import edu.ncsu.csc316.security_manager.list.ArrayBasedList;

public class AttackFileReaderTest {

	/** Filepaths of the testing attack file. */
	String attackfilePre = "input/ddos-preorder.txt";
	String attackfilePost = "input/ddos-postorder.txt";
	
	@Test
	public void testAttackFileReaderPre() {
		
		AttackFileReader preReader = new AttackFileReader(attackfilePre);
		
		ArrayBasedList<AttackStep> data = preReader.getData();
		
		assertEquals(15, data.size());
		
		try {
			preReader = new AttackFileReader("bologna");
			fail();
		} catch (RuntimeException e) {
			assertEquals(15, data.size());
			
			AttackStep testGoal = data.get(0);
			assertEquals(AttackType.ATTACKGOAL, testGoal.getType());
			assertEquals("Use DDoS Attack to Disrupt All Users", testGoal.getDescription());
			
			AttackStep testSub = data.get(1);
			assertEquals(AttackType.SUBGOAL_OR, testSub.getType());
			assertEquals("Attack Servers", testSub.getDescription());
			
			AttackStep testNode = data.get(3);
			assertEquals(AttackType.LEAF_OR, testNode.getType());
			assertEquals(0, (int)testNode.getProbability());
			assertEquals(6, (int)testNode.getImpact());
			assertEquals(5000, (int)testNode.getCost());
			assertEquals("\"Rent\" Existing BOTNET", testNode.getDescription());
			
		}
	}
}
