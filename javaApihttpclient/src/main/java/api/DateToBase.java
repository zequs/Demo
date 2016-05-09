package api;

import java.util.Iterator;
import java.util.Set;

public class DateToBase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "http://139.196.25.162:10005/web/doc/OldAccountList.aspx";
		LinkFilter linkFilter = new LinkFilter(){
			public boolean accept(String url) {
				if(url.contains("baidu")){
					return true;
				}else{
					return false;
				}
			}
			
		};
		
		
		Set<String> urlSet = HtmlParserToolDTB.extractLinks(url, linkFilter,null);
		
		Iterator<String> it = urlSet.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}

	
}
