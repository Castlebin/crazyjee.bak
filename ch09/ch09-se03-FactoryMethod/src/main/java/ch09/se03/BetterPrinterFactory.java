package ch09.se03;

public class BetterPrinterFactory implements OutputFactory {

	@Override
	public Output getOutput() {
		return new BetterPrinter();
	}

}
