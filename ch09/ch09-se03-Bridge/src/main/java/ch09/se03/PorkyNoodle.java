package ch09.se03;

public class PorkyNoodle extends AbstractNoodle {
	public PorkyNoodle(Peppery style) {
		super(style);
	}

	// 实现eat()抽象方法
	public void eat() {
		System.out.println("这是一碗稍嫌油腻的猪肉面条。" + super.style.style());
	}
}