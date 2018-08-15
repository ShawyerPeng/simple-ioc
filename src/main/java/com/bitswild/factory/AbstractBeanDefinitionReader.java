package com.bitswild.factory;

import com.bitswild.BeanDefinition;
import com.bitswild.BeanDefinitionReader;
import com.bitswild.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * 抽象的bean定义读取类
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {
    /**
     * 注册bean容器
     */
    private Map<String, BeanDefinition> registry;

    /**
     * 资源加载器
     */
    private ResourceLoader resourceLoader;

    /**
     * 构造器器必须有一个资源加载器， 默认插件创建一个map容器
     *
     * @param resourceLoader 资源加载器
     */
    protected AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
        this.registry = new HashMap<>();
        this.resourceLoader = resourceLoader;
    }

    /**
     * 获取容器
     */
    public Map<String, BeanDefinition> getRegistry() {
        return registry;
    }

    /**
     * 获取资源加载器
     */
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}