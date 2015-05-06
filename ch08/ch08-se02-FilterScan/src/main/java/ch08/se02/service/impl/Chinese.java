package ch08.se02.service.impl;

import ch08.se02.service.Axe;
import ch08.se02.service.Person;

public class Chinese implements Person {
	private Axe axe;
	
	@Override
	public void useAxe() {
		System.out.println(axe.chop());
	}

}
