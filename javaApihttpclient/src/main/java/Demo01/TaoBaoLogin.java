package Demo01;


import java.io.IOException;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;


public class TaoBaoLogin {

		private static final String LOGON_SITE = "http://www.taobao.com";
		private static final int LOGON_PORT = 80;
	
		private static final String TAOBAO_BASE_LOGIN_BEFORE = "http://member1.taobao.com/member/login.jhtml?f=top&redirectURL=http%3A%2F%2Fwww.taobao.com%2F";
		private static final String TAOBAO_BASE_LOGIN = "http://login.taobao.com/member/login.jhtml";

		public static void main(String args[]) throws HttpException, IOException {
			String taobaoUser="woshigoojje@163.com";
			
			String taobaoPwd="3DES_2_000000000000000000000000000000_61F0B8BE021BBBDD020919017B6816F5";
			String taobaoTid="XOR_1_000000000000000000000000000000_63584054400B0F717B750370";
			
			HttpClient client = new HttpClient();
			client.getHostConfiguration().setHost(LOGON_SITE, LOGON_PORT);
			
		
			String _tb_token_Value="";
			Cookie[] cookies = client.getState().getCookies();        
	        String responseString = processGet(client,null,TAOBAO_BASE_LOGIN_BEFORE,cookies,true,true);   
	        
	        responseString=responseString.substring(responseString.indexOf("_tb_token_")+"_tb_token_".length());
	        responseString=responseString.substring(responseString.indexOf("_tb_token_")+"_tb_token_".length());
	        int pointFirst = responseString.indexOf("value=")+"value='".length();
	        responseString=responseString.substring(pointFirst);
	        int pointEnd = responseString.indexOf(">")-1;
//	        _tb_token_Value=responseString.substring(0,pointEnd);
	        _tb_token_Value = "123UW5TcyMNYQwiAiwQRHhBfEF8QXtHcklnMWc=|Um5OcktyT3dDfkt2T3VBfCo=|U2xMHDJ7G2AHYg8hAS8WLwEhD1MyVDhfIVt1I3U=|VGhXd1llXGVYYFRpXGFYYl5mUWxOckh9Q3hNcE12SHNJdkhzTXhWAA==|VWldfS0QMAk0FCgTMx0hBFJ3BXoTaEQqFS4eOgd2WA5Y|VmNDbUMV|V2NDbUMV|WGRYeCgGZhtmH2VScVI2UT5fORtmD2gCawwuRSJHZAFsCWMOdVYyVTpbPR99HWAFYVMoRSlIM141SBZPCTlZJFkgCTYOMHtSbVVqJg8wCDd7BXsFJ1ozVD5XMBJ5HntSbVVqJggoBih+KA==|WWdHFyoKNxcrHyAdPQg8BCQYLBMuDjIPOgcnGy8QLQ0xDDUIXgg=|WmZYeCgGWjtdMVYoUn5EakpkOHs/Ey8aOgcnGjoFOAwidCI=|W2daelQEMQQ/H0hmWmNaZ19rVm1VbVJuUicaOAA1ATQJMAk1ATsOMQwwDzViTGxQBih+|XGdHFzkXNws0CioXNwg1CDJkMg==|XWRZZER5WWZGekN/X2FZY0N7T29VbU1xTXRUaEh0T3JSZlt7RHwq";
	        
	        PostMethod post = new PostMethod(TAOBAO_BASE_LOGIN);
	        NameValuePair[] params= new NameValuePair[] {        		
	        new NameValuePair("_oooo_", ""),
			new NameValuePair("_tb_token_", _tb_token_Value),
			new NameValuePair("abtest", ""),
			new NameValuePair("action", "Authenticator"),
			new NameValuePair("actionForStable", "enable_post_user_action"),
			new NameValuePair("CtrlVersion", "1,0,0,7"),
			new NameValuePair("done", ""),
			new NameValuePair("event_submit_do_login", "anything"),
			new NameValuePair("from", ""),
			new NameValuePair("loginType", "4"),
			new NameValuePair("mcheck", ""),
			new NameValuePair("mi_uid", ""),
			new NameValuePair("pstrong", ""),
			new NameValuePair("support", "000001"),
			new NameValuePair("tid", taobaoTid),
			new NameValuePair("TPL_password", taobaoPwd),
			new NameValuePair("TPL_redirect_url", ""),
			new NameValuePair("TPL_redirect_url", ""),
			new NameValuePair("TPL_redirect_url", ""),
			new NameValuePair("TPL_redirect_url", ""),
			new NameValuePair("TPL_redirect_url", ""),
			new NameValuePair("TPL_redirect_url", ""),
			new NameValuePair("TPL_username", taobaoUser),
			new NameValuePair("yparam", "")
	        };
	        processPost(client, post, TAOBAO_BASE_LOGIN, params, cookies, true, false);
			Header header=post.getResponseHeader("Location");
			String redirectUrl=header.getValue();
			
			
			responseString = processGet(client, null, redirectUrl, cookies, true, true);
			
			
			responseString=responseString.substring(0,responseString.indexOf("我的彩票"));
			System.out.println("main(String[]) - " + responseString); 

			String caiPiaoUrl=responseString.substring(responseString.lastIndexOf("<a")+"<a href='".length(),responseString.lastIndexOf(">")-1);
	
			processGet(client, null, caiPiaoUrl, cookies, true, false);

			
			
		}
		
		

		public static String processGet(HttpClient client,GetMethod get,String url,Cookie[] cookies,boolean needAppendCookies,boolean needResponse) throws IOException{
			if(client==null || url==null || url=="") return "";
			if(get==null)
				get=new GetMethod();
			get = new  GetMethod(url);  
			if(cookies!=null)
				get.setRequestHeader("Cookie" , cookies.toString());
	        client.executeMethod(get);
	        if(needAppendCookies){
		        cookies = client.getState().getCookies();   
		        client.getState().addCookies(cookies);   
	        }
	        if(needResponse)
	        	return get.getResponseBodyAsString();   
			get.releaseConnection();
			return "";
		}
		

		public static String processPost(HttpClient client,PostMethod post,String url,NameValuePair[] params,Cookie[] cookies,boolean needAppendCookies,boolean needResponse) throws IOException{
			if(client==null || url==null || url=="") return "";
			if(post==null)
				post = new PostMethod(url);
			
			if(params!=null && params.length>0)
				post.setRequestBody(params);
			if(cookies!=null)
				post.setRequestHeader("Cookie" , cookies.toString());
			client.executeMethod(post);
			if(needAppendCookies){
		        cookies = client.getState().getCookies();   
		        client.getState().addCookies(cookies);   
	        }
			if(needResponse)
	        	return post.getResponseBodyAsString();
			post.releaseConnection();
			return "";
		}
		

		public static String processDetail(String tempStr,String startFlag,String endFlag,int starts,int ends){
			if(tempStr==null || "".equals(tempStr)) return "";
			int start=tempStr.indexOf(startFlag);
			int end=tempStr.indexOf(endFlag);
			if(start==-1 || end==-1 || (end-ends)<(start+starts)) return "";
			try{
			tempStr=tempStr.substring(start+starts,end-ends);
			}catch(Exception e){
				System.out.println("processDetail(String, String, String, int, int) " + e.toString()); 
				return "";
			}
			return tempStr;
		}

}
