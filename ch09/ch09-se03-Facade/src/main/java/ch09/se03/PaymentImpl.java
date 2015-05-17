package ch09.se03;

public class PaymentImpl implements Payment {
	// 实现模拟顾客支付费用的方法
	public String pay() {
		String food = "快餐";
		System.out.println("你已经向收银员支付了费用，您购买的食物是：" + food);
		return food;
	}
}
