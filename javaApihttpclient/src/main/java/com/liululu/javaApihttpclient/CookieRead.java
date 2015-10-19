package com.liululu.javaApihttpclient;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;

public class CookieRead {
	public static void main(String[] args) throws Exception {
		// CloseableHttpClient client = HttpClients.createDefault();
//		final String url = "http://www.facaijin.com";
		final String url = "http://139.196.25.162:10005/web/doc/OldAccountList.aspx";
		
		final String CHARSET = "utf-8";
		// HttpGet httpget = new HttpGet(url);
		// CloseableHttpResponse response = httpclient.execute(httpget);
		HttpPost httpPost = new HttpPost(url);
		List<NameValuePair> pairs = new ArrayList<NameValuePair>();
		pairs.add(new BasicNameValuePair("userName", "13867017397"));
		pairs.add(new BasicNameValuePair("passWord", "fcj123"));
		httpPost.setEntity(new UrlEncodedFormEntity(pairs, CHARSET));

		HttpClient httpclient = HttpClientBuilder.create().build();;
		
		CookieStore cookieStore = new BasicCookieStore();
		BasicClientCookie netscapeCookie = new BasicClientCookie("name",
				"value");
		netscapeCookie.setVersion(0);
		netscapeCookie.setDomain("www.facaijin.com");
		netscapeCookie.setPath("/");
		cookieStore.addCookie(netscapeCookie);
		
		
		CloseableHttpClient client = HttpClients.custom()
				.setDefaultCookieStore(cookieStore).build();
		CloseableHttpResponse response = client.execute(httpPost);
		
		try {
			List<Cookie> list = cookieStore.getCookies();
			for (Cookie cookie : list) {
				System.out.println(cookie.getName());
				System.out.println(cookie.getValue());
			}
			System.out.println(response.getStatusLine());
			HttpEntity httpEntity = response.getEntity();
			httpEntity.getContent();
			
			for(Header header : response.getAllHeaders()){
				System.out.println(header);
			}
		} finally {
			response.close();
		}
	}
}