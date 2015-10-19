package com.liululu.javaApihttpclient;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
public class GetSample{
  public static void main(String[] args) {
  //构造HttpClient的实例
  HttpClient httpClient = new HttpClient();
  //创建GET方法的实例
  String url = "http://139.196.25.162:10005/web/doc/OldAccountList.aspx";
  GetMethod getMethod = new GetMethod(url);
  //使用系统提供的默认的恢复策略
  getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
    new DefaultHttpMethodRetryHandler());
  try {
   //执行getMethod
   int statusCode = httpClient.executeMethod(getMethod);
   if (statusCode != HttpStatus.SC_OK) {
    System.err.println("Method failed: "
      + getMethod.getStatusLine());
   }
   Cookie[] cookies = httpClient.getState().getCookies();
   int i = 0;
   for (Cookie c : cookies) {
       System.out.println(++i + ":   " + c);
   }
   Cookie cookie = new Cookie("domain","cookiename","cookievalue");
   
   //HTTP响应头部信息，这里简单打印
   Header[] headers=getMethod.getResponseHeaders();
       for(Header  h:  headers)
   	      System.out.println(h.getName()+" "+h.getValue());
   //读取内容 
   byte[] responseBody = getMethod.getResponseBody();
   //处理内容
   System.out.println(new String(responseBody));
   writeTxtFile(new String(responseBody),new File("getDemo01.html"));
  } catch (HttpException e) {
   //发生致命的异常，可能是协议不对或者返回的内容有问题
   System.out.println("Please check your provided http address!");
   e.printStackTrace();
  } catch (Exception e) {
   //发生网络异常
   e.printStackTrace();
  } finally {
   //释放连接
   getMethod.releaseConnection();
  }
 }
  
  public static boolean writeTxtFile(String content,File  fileName)throws Exception{
	  boolean flag=false;
	  FileOutputStream o=null;
	  try {
	   o = new FileOutputStream(fileName);
	      o.write(content.getBytes("UTF-8"));
	      o.close();
	   flag=true;
	  } catch (Exception e) {
	   // TODO: handle exception
	   e.printStackTrace();
	  }finally{
	  }
	  return flag;
	 }
  
}
