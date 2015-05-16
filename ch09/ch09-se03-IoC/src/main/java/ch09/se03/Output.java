package ch09.se03;

public interface Output {
    // 接口里定义的属性只能是常量
    int MAX_CACHE_LINE = 50;

    void getData(String msg);

    void out();

}
