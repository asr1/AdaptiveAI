package BasicAttacks;


import java.util.ArrayList;
import java.util.Random;

import General.AIAttackOptions;
import General.AttackType;
import General.Attacks;
import General.Class;

public class Warlock_Corruption extends Attacks {
	public Warlock_Corruption(Class attacker) {
		super(attacker);
		attackType = AttackType.BASIC_ATTACK;
		
		attackName = "Corruption";
		attackDescription = "Chose an enemy, deal flat damage plus a bonus.";
	
		damage = 10;
		speed = 7;
		critChance = 0;
		numOfTargets = 1;
	}
	
	@Override
	protected String attack(Class target) {
		String result = doBeginningActions(theAttacker, target);
		if (!result.equals("Success")) return result;
		
		Random random = new Random();
		int bonus = random.nextInt(10) + 5;
		
		int damageDealt = dealDamage(theAttacker, theTarget, damage + bonus, critChance);

		return "Used " + attackName + " on " + theTarget.name + " -- It did " + damageDealt + " damage\n";
	}


	@Override
	public void chooseTargetForAttack(Class target) {
		theTargets.add(target);
	}
	
	@Override
	public void chooseAITarget() {
		ArrayList<AIAttackOptions> parameters = new ArrayList<>();
		parameters.add(AIAttackOptions.PRIEST);
		parameters.add(AIAttackOptions.BARD);
		parameters.add(AIAttackOptions.MAGE);
		parameters.add(AIAttackOptions.RANDOM);
		chooseAttackTargetAI(parameters);
	}

}