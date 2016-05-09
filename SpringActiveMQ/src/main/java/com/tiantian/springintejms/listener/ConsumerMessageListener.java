package com.tiantian.springintejms.listener;

import java.util.Date;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;

import com.tiantian.springintejms.dao.TestDao;


public class ConsumerMessageListener implements MessageListener {

	@Autowired
	private TestDao testDao;
	
	private int count = 0;
	
	public void onMessage(Message message) {
			//��������֪�������߷��͵ľ���һ�����ı���Ϣ�������������ֱ�ӽ���ǿ��ת��������ֱ�Ӱ�onMessage�����Ĳ����ĳ�Message������TextMessage
			TextMessage textMsg = (TextMessage) message;
			System.out.println(new Date().toLocaleString() + "���յ�һ�����ı���Ϣ��");
			try {
				String text = textMsg.getText();
				System.out.println("��Ϣ�����ǣ�" + text);
				System.out.println("��ǰcount��ֵ�ǣ�" + count);
				testDao.insert(text + count);
				if (count == 0) {
					count ++;
					throw new RuntimeException("Error! ��������");
				}
			} catch (JMSException e) {
				e.printStackTrace();
			}
	}
	
	/*public void onMessage(Message message) {  
        //��������֪�������߷��͵ľ���һ�����ı���Ϣ�������������ֱ�ӽ���ǿ��ת��������ֱ�Ӱ�onMessage�����Ĳ����ĳ�Message������TextMessage  
        TextMessage textMsg = (TextMessage) message;  
        System.out.println("���յ�һ�����ı���Ϣ��");  
        try {  
            System.out.println("��Ϣ�����ǣ�" + textMsg.getText());  
            if (1 == 1) {  
                throw new RuntimeException("Error");  
            }  
        } catch (JMSException e) {  
            e.printStackTrace();  
        }  
	}  */

}
