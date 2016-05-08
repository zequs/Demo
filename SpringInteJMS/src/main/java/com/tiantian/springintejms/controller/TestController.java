package com.tiantian.springintejms.controller;

import java.util.Date;

import javax.jms.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tiantian.springintejms.dao.TestDao;
import com.tiantian.springintejms.service.ProducerService;

@Controller
@RequestMapping("/test")
public class TestController {

	@Autowired
	@Qualifier("queueDestination")
	private Destination destination;
	
	@Autowired
	private TestDao testDao;
	
	@Autowired
	private ProducerService producerService;
	
	@RequestMapping("/first")
	public String first() {
	    System.out.println("测试");
		producerService.sendMessage(destination, "你好，现在是：" + new Date().toLocaleString());
		return "/test/first";
	}
	
	@RequestMapping("/all")
	@ResponseBody
	public Object findAll() {
	    System.out.println("all");
		return testDao.findAll();
	}
	public String aaa(){
	    System.out.println("主页");
	    return "/index.jsp";
	}
}
