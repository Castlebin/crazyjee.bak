package ch09.se03;

public class BigImage implements Image {
	
	public BigImage() {
		try {// 模拟大对象创建耗时
			Thread.sleep(3 * 1000);
			System.out.println("大图片对象加载成功…");
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void show() {
		System.out.println("绘制大图片对象，进行显示…");
	}

}
