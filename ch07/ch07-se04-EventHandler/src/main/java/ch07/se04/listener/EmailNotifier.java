package ch07.se04.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import ch07.se04.event.EmailEvent;

public class EmailNotifier implements ApplicationListener {

	// 当容器中有事件抛出时自动被触发，典型的观察者模式
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		// 本监听器只处理EmailEvent，其他略过
		if(event instanceof EmailEvent) {
			EmailEvent evt = (EmailEvent)event;
			System.out.println("需要发送邮件的接收地址：" + evt.getAddress());
			System.out.println("需要发送邮件的内容为：" + evt.getText());
		} else {
			// 其他事件都不做处理
			System.out.println("其他事件：" + event);
		}
	}

}
