package ch09.se03;

public class Computer {
	private String name;
	private Output out;
	
	public void keyIn(String msg) {
        out.getData(msg);
    }

    public void print() {
        out.out();
    }
	
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Output getOut() {
		return out;
	}

    public void setOut(Output out) {
        this.out = out;
    }

}
