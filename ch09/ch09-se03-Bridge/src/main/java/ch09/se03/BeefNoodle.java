package ch09.se03;

public class BeefNoodle extends AbstractNoodle {
	public BeefNoodle(Peppery style) {
		super(style);
	}

	// 实现eat()抽象方法
	public void eat() {
		System.out.println("这是一碗美味的牛肉面条。" + super.style.style());
	}
}