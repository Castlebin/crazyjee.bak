package ch09.se03;

import org.junit.Test;

public class CommandTest {
	
	@Test
	public void testCommand1() {
		ProcessArray pa = new ProcessArray();
		int[] target = {3, -4, 6, 4};
		pa.each(target, new Command() {
			@Override
			public void process(int[] target) {
				for(int tmp : target) {
					System.out.println("迭代输出目标数组元素：" + tmp);
				}
			}
		});
	}
	
	@Test
	public void testCommand2() {
		ProcessArray pa = new ProcessArray();
		int[] target = {3, -4, 6, 4};
		pa.each(target, new Command() {
			@Override
			public void process(int[] target) {
				int sum = 0;
				for(int tmp : target) {
					sum += tmp;
				}
				
				System.out.println("目标数组元素和为：" + sum);
			}
		});
	}
	
	@Test
	public void testLambdaTest1() {
		ProcessArray pa = new ProcessArray();
		int[] target = {3, -4, 6, 4};
		pa.each(target, array -> {
			for(int tmp : array) {
				System.out.println("迭代输出目标数组元素：" + tmp);
			}
		});
	}
	
	@Test
	public void testLambdaTest2() {
		ProcessArray pa = new ProcessArray();
		int[] target = {3, -4, 6, 4};
		pa.each(target, array -> {
			int sum = 0;
			for(int tmp : target) {
				sum += tmp;
			}
			
			System.out.println("目标数组元素和为：" + sum);
		});
	}
	
}
