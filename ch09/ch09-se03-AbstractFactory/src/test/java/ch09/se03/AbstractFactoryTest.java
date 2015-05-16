package ch09.se03;

import org.junit.Test;

public class AbstractFactoryTest {

    @Test
    public void testAbstractFactory() {
        // 创建一个工厂
        OutputFactory factory = OutputFactoryFactory.getOutputFactory("better");
        Computer computer = new Computer(factory.getOutput());

        computer.keyIn("轻量级ＪａｖａＥＥ企业级应用开发实战");
        computer.keyIn("疯狂Ｊａｖａ讲义");

        computer.print();
    }

}
