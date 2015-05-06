package ch08.se02.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import ch08.se02.domain.Item;

@Repository("itemDao")
public class ItemDaoImpl extends BaseDaoImpl<Item> {

	@Autowired
	@Qualifier("item")
	private Item item;
	
}
