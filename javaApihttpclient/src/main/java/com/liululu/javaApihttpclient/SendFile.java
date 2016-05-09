package com.liululu.javaApihttpclient;

/**
 * Hello world!
 *
 */
import java.io.File;   
import java.io.IOException;   
import java.nio.charset.Charset;
   
import org.apache.http.HttpEntity;   
import org.apache.http.HttpResponse;   
import org.apache.http.HttpStatus;   
import org.apache.http.client.ClientProtocolException;   
import org.apache.http.client.HttpClient;   
import org.apache.http.client.methods.HttpPost;   
import org.apache.http.entity.mime.MultipartEntity;   
import org.apache.http.entity.mime.content.FileBody;   
import org.apache.http.entity.mime.content.StringBody;   
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;   
   
public class SendFile {   

	public static void main(String[] args) throws ClientProtocolException,   
            IOException {   
        HttpClient httpclient = HttpClientBuilder.create().build();   
        //请求处理页面   
        HttpPost httppost = new HttpPost(   
                "http://localhost:8080/JobsAdmin/manage/updateDemoAction");   
        //创建待处理的文件   
        FileBody file = new FileBody(new File("123.txt"));   
        //创建待处理的表单域内容文本   
        StringBody descript00 =  new StringBody("中国", Charset.forName("UTF-8"));
        StringBody descript01 = new StringBody("httpclient提交", Charset.forName("UTF-8"));   
   
        //对请求的表单域进行填充   
        MultipartEntity reqEntity = new MultipartEntity();   
        reqEntity.addPart("uploadFile", file);   
        reqEntity.addPart("descript00", descript00); 
        reqEntity.addPart("descript01", descript01);
        //设置请求   
        httppost.setEntity(reqEntity);
        //执行   
        HttpResponse response = httpclient.execute(httppost);   
//        System.out.println(response.getStatusLine());
//        System.out.println(response.getStatusLine().getStatusCode());
        
        if(HttpStatus.SC_OK==response.getStatusLine().getStatusCode()){   
            HttpEntity entity = response.getEntity();
            System.out.println(entity.toString());
            //显示内容   
            if (entity != null) {  
                System.out.println(EntityUtils.toString(entity));
                EntityUtils.consume(entity);
            }
//            else{
//            	System.out.println("无返回实体类");
//            }
            
        }   
    }   
}
