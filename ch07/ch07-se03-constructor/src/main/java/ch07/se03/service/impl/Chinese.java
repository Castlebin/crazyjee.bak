package ch07.se03.service.impl;

import ch07.se03.service.Axe;
import ch07.se03.service.Person;

public class Chinese implements Person {
	private Axe axe;
	
	// 定义构造注入需要的构造器
	public Chinese(Axe axe) {
		this.axe = axe;
	}

	@Override
	public void useAxe() {
		System.out.println(axe.chop());
	}

}
