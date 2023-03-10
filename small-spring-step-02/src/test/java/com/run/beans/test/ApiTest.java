package com.run.beans.test;

import com.run.beans.factory.config.BeanDefinition;
import com.run.beans.factory.support.DefaultListableBeanFactory;
import com.run.beans.test.bean.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @desc:
 * @author: AruNi_Lu
 * @date: 2023/3/8
 */
@SpringBootTest(classes = ApiTest.class)
public class ApiTest {

    @Test
    public void test_BeanFactory() {
        // 1. 初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 这里直接把 UserService.class 传递给了 BeanDefinition，而不是像上次那样直接 new UserService()
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);

        // 2. 注册 bean
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 3. 第一次获取 bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
        // 4. 第二次获取 bean from Singleton
        UserService userService_singleton = (UserService) beanFactory.getBean("userService");
        userService_singleton.queryUserInfo();
    }

}
