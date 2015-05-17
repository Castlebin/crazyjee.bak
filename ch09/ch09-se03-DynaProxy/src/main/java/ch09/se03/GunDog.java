package ch09.se03;

public class GunDog implements Dog {

	@Override
	public void info() {
		System.out.println("我是一只猎狗");
	}

	@Override
	public void run() {
		System.out.println("我奔跑迅速！");
	}

}
