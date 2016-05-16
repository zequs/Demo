package com.tiantian.springintejms.service;

import java.io.Serializable;

import javax.jms.Destination;

public interface ProducerService {

	/**
	 * ������ͨ�Ĵ��ı���Ϣ
	 * @param destination
	 * @param message
	 */
	public void sendMessage(Destination destination, String message);
	
	/**
	 * ����һ��ObjectMessage
	 * @param destination
	 * @param obj
	 */
	public void sendMessage(Destination destination, Serializable obj);
	
}
