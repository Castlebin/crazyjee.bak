package ch08.se02.service.impl;

import ch08.se02.service.Axe;

public class StoneAxe implements Axe {

	@Override
	public String chop() {
		return "石斧砍柴很慢！";
	}

}
