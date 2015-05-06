package ch08.se02.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import ch08.se02.service.Axe;
import ch08.se02.service.Person;

@Component
public class Woman implements Person {
	private Axe axe;
	
	@Override
	public void useAxe() {
		System.out.println(axe.chop());
	}

	public Axe getAxe() {
		return axe;
	}

	@Resource(name="stoneAxe")
	public void setAxe(Axe axe) {
		this.axe = axe;
	}

}
