package api;

import java.util.Set;
public class Crawler {
//	final String URL = "http://www.twt.edu.cn";
	final String URL = "http://121.40.70.198:8888";
	/* 使用种子 url 初始化 URL 队列*/
	private void initCrawlerWithSeeds(String[] seeds)
	{
		for(int i=0;i<seeds.length;i++)
			LinkDB.addUnvisitedUrl(seeds[i]);
	}
	
	/* 爬取方法*/
	public void crawling(String[] seeds)
	{
		LinkFilter filter = new LinkFilter(){
			//提取以 http://www.twt.edu.cn 开头的链接
			public boolean accept(String url) {
				if(url.startsWith(URL))
					return true;
				else
					return false;
			}
		};
		//初始化 URL 队列
		initCrawlerWithSeeds(seeds);
		//循环条件：待抓取的链接不空且抓取的网页不多于 1000
		while(!LinkDB.unVisitedUrlsEmpty()&&LinkDB.getVisitedUrlNum()<=1000)
		{
			//队头 URL 出对
			String visitUrl=LinkDB.unVisitedUrlDeQueue();
			System.out.println("Queue:"+visitUrl);
			if(visitUrl==null)
				continue;
			if(visitUrl.substring(visitUrl.length()-1).equals("＃"))
				continue;
			FileDownLoader downLoader=new FileDownLoader();
			//下载网页
			String charset = downLoader.downloadFile(visitUrl);
			//该 url 放入到已访问的 URL 中
			LinkDB.addVisitedUrl(visitUrl);
			//提取出下载网页中的 URL
			
			Set<String> links=HtmlParserTool.extractLinks(visitUrl,filter,charset);
			//新的未访问的 URL 入队
			for(String link:links)
			{
					LinkDB.addUnvisitedUrl(link);
			}
		}
	}
	//main 方法入口
	public static void main(String[]args)
	{
		Crawler crawler = new Crawler();
//		crawler.crawling(new String[]{"http://www.twt.edu.cn"});
//		crawler.crawling(new String[]{"http://www.twt.edu.cn/＃"});
//		crawler.crawling(new String[]{"http://www.kantingyong.com:8080/ksStaffMsg/liululu.jsp"});
		crawler.crawling(new String[]{"http://121.40.70.198:8888/selfMatching/index/jianzhi.from"});
		
	}
}
