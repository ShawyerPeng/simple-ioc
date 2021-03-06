package com.bitswild.myspring;

import com.bitswild.AutowireBeanFactory;
import com.bitswild.BeanDefinition;
import com.bitswild.PropertyValue;
import com.bitswild.PropertyValues;
import com.bitswild.factory.BeanFactory;
import org.junit.Test;

/**
 * 测试
 */
public class BeanFactoryTest {
    // 类全名称
    private final String classname = "com.bitswild.myspring.HelloWorld";
    // 属性名称
    private final String property = "text";
    // 属性值
    private String value = "测试自动机";
    // 类id
    private final String name = "hello";

    @Test
    public void test() throws Exception {
        // 创建自动注册bean工厂
        BeanFactory beanfactory = new AutowireBeanFactory();
        // 创建一个bean定义对象
        BeanDefinition beandefinition = new BeanDefinition();
        // 给bean定义对象设置类名并创建class对象
        beandefinition.setClassName(classname);

        // 创建一个成员变量集合
        PropertyValues pv = new PropertyValues();

        // 给bean定义设置成员变量集合
        beandefinition.setPropertyValues(pv);

        // 向bean定义添加成员变量集合
        beandefinition.getPropertyValues().addPropertyValue(new PropertyValue(property, value));

        // bean工厂将bean定义注册到容器中
        beanfactory.registerBeanDefinition(name, beandefinition);

        // 从容器中获取bean实例
        HelloWorld hello = (HelloWorld) beanfactory.getBean(name);

        // 调用实例方法
        hello.say();
    }
}