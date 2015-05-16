package ch09.se03;

public class OutputFactory {

    public Output getOutput() {
        // 用于决定到底使用哪个Output的实现类，这样Computer作为调用者就不必与具体的实现类耦合了，可以自由切换Output实现类
        return new BetterPrinter();
    }

}
