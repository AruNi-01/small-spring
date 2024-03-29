package com.run.test.event;

import com.run.context.ApplicationListener;

import java.util.Date;

/**
 * @desc: 用于监听 CustomEvent 事件的监听器，这里你可以处理自己想要的操作，比如一些用户注册后发送优惠券和短信通知等
 * @author: AruNi_Lu
 * @date: 2023/4/2
 */
public class CustomEventListener implements ApplicationListener<CustomEvent> {

    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("收到：" + event.getSource() + "消息，当前时间：" + new Date());
        System.out.println("消息：" + event.getId() + ":" + event.getMessage());
    }

}
