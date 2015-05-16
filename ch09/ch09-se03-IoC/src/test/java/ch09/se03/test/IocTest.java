package ch09.se03.test;

import org.junit.Test;

import ch09.se03.Computer;
import ch09.se03.ioc.ApplicationContext;
import ch09.se03.ioc.impl.CrazyitXmlApplicationContext;

public class IocTest {

	@Test
    public void testIoc() throws Exception {
        // 创建自己的IoC容器
        ApplicationContext ctx = new CrazyitXmlApplicationContext("src/main/resources/beans.xml");

        // 从IoC容器中取出bean
        Computer computer = (Computer) ctx.getBean("computer");
        computer.keyIn("疯狂Ｊａｖａ讲义");
        computer.keyIn("轻量级ＪａｖａＥＥ企业应用实战");

        computer.print();
        
        System.out.println(ctx.getBean("now"));
        Thread.sleep(5 * 1000);
        System.out.println(ctx.getBean("now"));        
    }

}
