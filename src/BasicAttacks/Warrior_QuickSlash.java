package BasicAttacks;

import General.AttackType;
import General.Attacks;
import General.Class;

public class Warrior_QuickSlash extends Attacks {
	public Warrior_QuickSlash(Class attacker) {
		super(attacker);
		attackType = AttackType.BASIC_ATTACK;
		
		attackName = "Quick Slash";
		attackDescription = "Choose an enemy, deal damage to that player.";
	
		damage = 10;
		speed = 4;
		critChance = 20;
		numOfTargets = 1;
	}
	
	@Override
	protected String attack(Class target) {
		if(!doBeginningActions(theAttacker, target)) return "No attack";
		
		dealDamage(theAttacker, target, damage, critChance);
		
		return "Used " + attackName + " on " + target.name + "\n";
	}

	@Override
	public void chooseTargetForAttack(Class target) {
		theTargets.add(target);
	}

}