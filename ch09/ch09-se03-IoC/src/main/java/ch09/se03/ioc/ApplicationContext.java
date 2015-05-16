package ch09.se03.ioc;

// 简单的实现一个类似Spring的容器
public interface ApplicationContext {

    // 获取容器中的bean
    Object getBean(String name) throws Exception;

}
