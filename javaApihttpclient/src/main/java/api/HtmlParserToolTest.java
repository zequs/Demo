package api;


import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

public class HtmlParserToolTest {

	@Test
	public void testExtractLinks() {
		String url = "http://www.baidu.com";
		LinkFilter linkFilter = new LinkFilter(){
			public boolean accept(String url) {
				if(url.contains("baidu")){
					return true;
				}else{
					return false;
				}
			}
			
		};
		Set<String> urlSet = HtmlParserTool.extractLinks(url, linkFilter,null);
		
		Iterator<String> it = urlSet.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}

}
