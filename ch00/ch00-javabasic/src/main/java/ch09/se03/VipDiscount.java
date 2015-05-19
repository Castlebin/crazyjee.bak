package ch09.se03;

public class VipDiscount implements DiscountStrategy {

	@Override
	public double getDiscount(double originPrice) {
		return originPrice * 0.8;
	}

}
