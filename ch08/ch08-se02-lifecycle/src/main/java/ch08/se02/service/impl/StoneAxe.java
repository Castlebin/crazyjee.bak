package ch08.se02.service.impl;

import org.springframework.stereotype.Component;

import ch08.se02.service.Axe;

@Component
public class StoneAxe implements Axe {

	@Override
	public String chop() {
		return "石斧砍柴很慢！";
	}

}
