package ch09.se03;

import org.junit.Test;

public class FactoryMethodTest {

    @Test
    public void testFactoryMethod() {
        // 创建一个工厂
        OutputFactory factory = new BetterPrinterFactory();
        Computer computer = new Computer(factory.getOutput());

        computer.keyIn("轻量级ＪａｖａＥＥ企业级应用开发实战");
        computer.keyIn("疯狂Ｊａｖａ讲义");

        computer.print();
    }

}
