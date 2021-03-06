package com.tiantian.springintejms.listener;

import java.util.Date;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.tiantian.springintejms.dao.TestDao;


public class ConsumerMessageListener implements MessageListener {

	@Autowired
	private TestDao testDao;
	
	@Autowired
	@Qualifier("testDao2") 
	private TestDao testDao2;
	
	private int count = 0;
	
	public void onMessage(Message message) {
			//这里我们知道生产者发送的就是一个纯文本消息，所以这里可以直接进行强制转换，或者直接把onMessage方法的参数改成Message的子类TextMessage
			TextMessage textMsg = (TextMessage) message;
			System.out.println(new Date().toLocaleString() + "接收到一个纯文本消息。");
			try {
				String text = textMsg.getText();
				System.out.println("消息内容是：" + text);
				System.out.println("当前count的值是：" + count);
				testDao.insert(text + count);
				testDao2.insert(text + count);
				if (count == 0) {
					count ++;
					throw new RuntimeException("Error! 出错啦！");
				}
			} catch (JMSException e) {
				e.printStackTrace();
			}
	}
	
	/*public void onMessage(Message message) {  
        //这里我们知道生产者发送的就是一个纯文本消息，所以这里可以直接进行强制转换，或者直接把onMessage方法的参数改成Message的子类TextMessage  
        TextMessage textMsg = (TextMessage) message;  
        System.out.println("接收到一个纯文本消息。");  
        try {  
            System.out.println("消息内容是：" + textMsg.getText());  
            if (1 == 1) {  
                throw new RuntimeException("Error");  
            }  
        } catch (JMSException e) {  
            e.printStackTrace();  
        }  
	}  */

}
