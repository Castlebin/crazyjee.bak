package ch08.se02.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import ch08.se02.service.Axe;
import ch08.se02.service.Person;

@Component
public class Chinese implements Person {
	
	@Resource(name="steelAxe")
	private Axe axe;
	
	@Override
	public void useAxe() {
		System.out.println(axe.chop());
	}
	
	@PostConstruct
	public void init() {
		System.out.println("init...");
	}
	
	@PreDestroy
	public void close() {
		System.out.println("destory...");
	}

}
