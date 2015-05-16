package ch09.se03;

import org.junit.Test;

public class SimpleFactoryTest {

    @Test
    public void testSimleFactory() {
        // 创建一个工厂
        OutputFactory factory = new OutputFactory();
        Computer computer = new Computer(factory.getOutput());

        computer.keyIn("轻量级ＪａｖａＥＥ企业级应用开发实战");
        computer.keyIn("疯狂Ｊａｖａ讲义");

        computer.print();
    }

}
