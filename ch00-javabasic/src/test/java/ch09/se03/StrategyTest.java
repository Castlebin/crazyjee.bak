package ch09.se03;

import org.junit.Test;

public class StrategyTest {
	
	@Test
	public void testStrategy1() {
		DiscountContext dc = new DiscountContext(null);
		double price = 79;
		System.out.println("打完折后的书价：" + dc.getDiscountPrice(price));
		
		// 改变策略
		dc.changeStrategy(new VipDiscount());
		System.out.println("VIP打完折后的书价：" + dc.getDiscountPrice(price));
	}

}
