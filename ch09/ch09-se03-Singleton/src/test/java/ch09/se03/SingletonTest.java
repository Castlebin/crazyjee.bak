package ch09.se03;

import org.junit.Test;

public class SingletonTest {

    @Test
    public void testSingleton() {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        System.out.println(s1 == s2);// true
    }

}
