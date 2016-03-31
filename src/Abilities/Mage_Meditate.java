package Abilities;

import General.AttackType;
import General.Attacks;
import General.Class;

public class Mage_Meditate extends Attacks {
	public Mage_Meditate(Class attacker) {
		super(attacker);
		attackType = AttackType.ABILITIES;
		
		attackName = "Meditate";
		attackDescription = "Regain 30 and a +20 shield bonus.";
	
	
		damage = 0;
		speed = 10;
		cost = 0;
		critChance = 0;
		numOfTargets = 0;
	}
	
	@Override
	protected String attack(Class target) {
		if (theAttacker.turnsStunned > 0) return "No attack";
		
		restore(0, 10, 30, theAttacker);
		
		return "Used " + attackName + "\n";
	}
	
	@Override
	public void chooseTargetForAttack(Class target) {
		theTargets.add(target);
	}
	
	@Override
	public boolean getSoftCap() {
		if (theAttacker.currentEnergy < 60) {
			return true;
		}
		
		return false;
	}

	@Override
	public void chooseAITarget() {
		chooseTargetForAttack(theAttacker);
	}

}
