package ch08.se02.service.impl;

import org.springframework.stereotype.Component;

import ch08.se02.service.Axe;

@Component
public class SteelAxe implements Axe {

	@Override
	public String chop() {
		return "钢斧砍柴很快！";
	}

}
