package edu.ncsu.csc316.security_manager.attack;

/**
 * This class represents the information contained in a
 * node of an attack tree.
 * @author Nicholas Board (ndboard)
 */
public class AttackStep {

	/** The attackstep's corresponding AttackType. */
	private AttackType type;
	/** The attackstep's corresponding description. */
	private String description;
	/** The attackstep's corresponding probability. */
	private double probability;
	/** The attackstep's corresponding impact. */
	private double impact;
	/** The attackstep's corresponding cost. */
	private double cost;
	
	/**
	 * Constructor for an AttackStep object that is either the
	 * AttackGoal or a SubGoal.
	 * @param newRelation The relation used to set the type of the AttackStep.
	 * @param newDescription The description of the AttackStep.
	 */
	public AttackStep( String newRelation, String newDescription ) {
		
		
		if( newRelation.equals( "A" ) ) {
			this.setType( AttackType.SUBGOAL_AND );
		}
		else if( newRelation.equals( "O" ) ) {
			this.setType( AttackType.SUBGOAL_OR );
		}
		else {
			this.setType( AttackType.ATTACKGOAL );
		}
		
		this.setDescription( newDescription );
	}
	
	/**
	 * Constructor for an AttackStep object that is a leaf.
	 * Contains information on probability, impact, and cost.
	 * @param newRelation The relation used to set the type of AttackStep.
	 * @param newProbability The probability of the AttackStep.
	 * @param newImpact The impact of the AttackStep.
	 * @param newCost The cost of the AttackStep.
	 * @param newDescription The description of the AttackStep.
	 */
	public AttackStep( String newRelation, double newProbability, double newImpact, double newCost, String newDescription ) {
		
		if( newRelation.equals( "A" ) ) {
			this.setType( AttackType.LEAF_AND );
		}
		else if( newRelation.equals( "O" ) ) {
			this.setType( AttackType.LEAF_OR );
		}
		
		this.setProbability(newProbability);
		this.setImpact(newImpact);
		this.setCost(newCost);
		this.setDescription(newDescription);
	}

	/**
	 * Getter method for the AttackStep's AttackType.
	 * @return the type
	 */
	public AttackType getType() {
		return type;
	}

	/**
	 * Setter method for the AttackStep's AttackType.
	 * @param type the type to set
	 */
	private void setType(AttackType type) {
		this.type = type;
	}


	/**
	 * Getter method for the AttackStep's description.
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Setter method for the AttackStep's description.
	 * @param description the description to set
	 */
	private void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Getter method for the AttackStep's probability.
	 * @return the probability
	 */
	public double getProbability() {
		return probability;
	}

	/**
	 * Setter method for the AttackStep's probability.
	 * @param probability the probability to set
	 */
	private void setProbability(double probability) {
		this.probability = probability;
	}

	/**
	 * Getter method for the AttackStep's impact.
	 * @return the impact
	 */
	public double getImpact() {
		return impact;
	}

	/**
	 * Setter method for the AttackStep's impact.
	 * @param impact the impact to set
	 */
	private void setImpact(double impact) {
		this.impact = impact;
	}

	/**
	 * Getter method for the AttackStep's cost.
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * Setter method for the AttackStep's cost.
	 * @param cost the cost to set
	 */
	private void setCost(double cost) {
		this.cost = cost;
	}
}
