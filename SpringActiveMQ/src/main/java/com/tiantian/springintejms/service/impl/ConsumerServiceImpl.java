package com.tiantian.springintejms.service.impl;

import javax.jms.JMSException;

import com.tiantian.springintejms.service.ConsumerService;

public class ConsumerServiceImpl implements ConsumerService {

	public void receiveMessage(String message) throws JMSException {
		System.out.println("------------------�����߽�����Ϣ-----------------");
		System.out.println("-----------------�����߷�������Ϣ�ǣ�" + message);
	}

}
