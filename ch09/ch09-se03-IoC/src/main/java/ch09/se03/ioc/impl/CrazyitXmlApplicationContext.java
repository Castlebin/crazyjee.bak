package ch09.se03.ioc.impl;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import ch09.se03.ioc.ApplicationContext;

public class CrazyitXmlApplicationContext implements ApplicationContext {
    // 首先，需要一个Map来保存容器中所有的singleton bean实例
    private Map<String, Object> objPool = Collections.synchronizedMap(new HashMap<>());
    
    //　保存prototype bean信息
    private Map<String, String> prototypeInfoMap = Collections.synchronizedMap(new HashMap<>());

    // 配置文件对应的Document对象
    private Document doc;
    // 配置文件根节点对应的Element对象
    private Element root;

    // 使用配置文件来创建和初始化容器
    public CrazyitXmlApplicationContext(String filePath) throws Exception {
        SAXReader reader = new SAXReader();
        doc = reader.read(new File(filePath));
        root = doc.getRootElement();
        initPool();
        initProp();
    }
    
    @Override
    public Object getBean(String name) throws Exception {
        // 对于singleton对象，容器中已经初始化了所有bean实例，直接返回即可，但是prototype对象则得执行创建对象操作
    	Object obj = objPool.get(name);
    	if(obj != null) {
    		return obj;
    	}
    	
        return Class.forName(prototypeInfoMap.get(name)).newInstance();
    }

    // 初始化所有的singleton bean
    private void initPool() throws Exception {
        // 遍历配置文件中每个bean元素，创建对象
        for(Object obj : root.elements("bean")) {
            Element beanEle = (Element) obj;
            // id
            String beanId = beanEle.attributeValue("id");
            // class
            String beanClass = beanEle.attributeValue("class");
            // beanScope
            String beanScope = beanEle.attributeValue("scope");

            // 单例bean，创建、并放入容器中
            if(beanScope == null || beanScope=="singleton") {
            	Object instance = Class.forName(beanClass).newInstance();
                objPool.put(beanId, instance);
            } else if(beanScope.equals("prototype")) {
            	prototypeInfoMap.put(beanId, beanClass);
            }
        }
    }

    // 设置容器中bean的属性
    private void initProp() throws Exception{
        // 遍历配置文件中每个bean元素，使用property元素的内容来设置它们的属性
        for(Object obj : root.elements("bean")) {
            Element beanEle = (Element) obj;
            // id
            String beanId = beanEle.attributeValue("id");
            // beanScope
            String beanScope = beanEle.attributeValue("beanScope");

            // 单例bean，设置属性
            if(beanScope == null || beanScope=="singleton") {
                // 从容器中取出该bean
                Object bean = objPool.get(beanId);
                // 取出property值，设置bean的属性
                for(Object prop : beanEle.elements("property")) {
                    Element propEle = (Element)prop;
                    // 取得<property>元素的name属性
                    String propName = propEle.attributeValue("name");
                    // value
                    String propValue = propEle.attributeValue("value");
                    // ref
                    String propRef = propEle.attributeValue("ref");

                    // 拼出属性名的set方法名
                    String setMettodName = "set" + propName.substring(0, 1).toUpperCase() + propName.substring(1);
                    Method setter = null;
                    // 有value属性则用value值来设置属性值，有ref用ref
                    if(propValue != null) {
                        setter = bean.getClass().getMethod(setMettodName, String.class);
                        // 执行setter方法设置属性
                        setter.invoke(bean, propValue);
                    } else if(propRef != null) {
                        // 取得ref对应的bean实例
                        Object refBean = objPool.get(propRef);
                        if(refBean == null) {
                            throw new RuntimeException("容器中不存在" + propRef +"bean，初始化" + beanId + "bean失败！");
                        }

                        // 找出ref对象所实现的所有接口，看看是否存在名字为setMettodName的方法
                        for(Class<?> supperInterface : refBean.getClass().getInterfaces()) {
                            try {
                                setter = bean.getClass().getMethod(setMettodName, supperInterface);
                                // 找到一个，则返回
                                break;
                            } catch(NoSuchMethodException e) {// 异常，说明没找到，那么继续找
                                continue;
                            }
                        }
                        // 没找到，那么看看类本身是否有
                        if(setter == null) {
                            setter = bean.getClass().getMethod(setMettodName, refBean.getClass());
                        }

                        // 执行注入
                        setter.invoke(bean, refBean);
                    }
                }
            }
        }
    }

}
