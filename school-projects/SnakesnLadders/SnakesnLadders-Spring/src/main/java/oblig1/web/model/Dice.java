package oblig1.web.model;

import java.util.Random;

import oblig1.web.interfaces.DiceInterface;

public class Dice implements DiceInterface {
	
	private Integer num;
	
	public Dice() {
		num = 1;
	}

	@Override
	public Integer getDiceNumber() {
		return this.num;
	}

	@Override
	public Integer rollDice() {
		int dice = new Random().nextInt(6) + 1;
		this.num = dice;
		return dice;
	}
	
}
