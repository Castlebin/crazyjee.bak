package ch10.hrsystem.exception;

public class HrException extends RuntimeException {
	private static final long serialVersionUID = 2710552462681556868L;

	public HrException() {
	}

	public HrException(String msg) {
		super(msg);
	}
}