package com.tiantian.springintejms.test;

import javax.jms.Destination;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tiantian.springintejms.entity.Email;
import com.tiantian.springintejms.service.ProducerService;

/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")*/
public class ProducerConsumerTest {

	@Autowired
	private ProducerService producerService;
	@Autowired
	@Qualifier("queueDestination")
	private Destination destination;
	
	@Autowired
	@Qualifier("sessionAwareQueue")
	private Destination sessionAwareQueue;
	@Autowired
	@Qualifier("adapterQueue")
	private Destination adapterQueue;
	
	@Test
	public void testSend() {
		for (int i=0; i<1; i++) {
			producerService.sendMessage(destination, "��ã������ߣ�������Ϣ��" + (i+1));
		}
	}
	
	@Test
	public void testSessionAwareMessageListener() {
		producerService.sendMessage(sessionAwareQueue, "����SessionAwareMessageListener");
	}
	
	@Test
	public void testMessageListenerAdapter() {
		producerService.sendMessage(adapterQueue, "����MessageListenerAdapter");
	}
	
	@Test
	public void testObjectMessage() {
		Email email = new Email("zhangsan@xxx.com", "����", "����");
//		producerService.sendMessage(destination, email);
		producerService.sendMessage(adapterQueue, email);
	}
	
//	@Test
	public void test() {
		
	}
	
}
