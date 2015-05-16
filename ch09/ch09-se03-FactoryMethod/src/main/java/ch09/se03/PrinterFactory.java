package ch09.se03;

public class PrinterFactory implements OutputFactory {

	@Override
	public Output getOutput() {
		return new Printer();
	}

}
