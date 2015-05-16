package ch09.se03;

public class OutputFactoryFactory {

	// 返回具体的工厂
	public static OutputFactory getOutputFactory(String type) {
		if(type.equals("better")) {
			return new BetterPrinterFactory();
		} else {
			return new PrinterFactory();
		}
	}
	
}
