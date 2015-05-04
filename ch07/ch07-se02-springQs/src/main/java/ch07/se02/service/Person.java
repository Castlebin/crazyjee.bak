package ch07.se02.service;

public class Person {
	
	private Axe axe;
	
	// 设值需要的setter方法
	public void setAxe(Axe axe) {
		this.axe = axe;
	}
	
	public void useAxe() {
		System.out.println("我打算去砍点柴火！");
		
		// 调用Axe的chop()方法，表示Person依赖axe对象
		System.out.println(axe.chop());
	}
	
}
