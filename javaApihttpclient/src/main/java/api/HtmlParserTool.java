package api;


import java.util.HashSet;
import java.util.Set;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.filters.OrFilter;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

//本类创建用于HTML文件解释工具
public class HtmlParserTool {

	// 本方法用于提取某个html文档中内嵌的链接
	public static Set<String> extractLinks(String url, LinkFilter filter ,String charset) {
		Set<String> links = new HashSet<String>();
		try {
			// 1、构造一个Parser，并设置相关的属性
			Parser parser = new Parser(url);
			if(charset!=null){
				parser.setEncoding(charset);
			}else{
				parser.setEncoding("UTF-8");
//				parser.setEncoding("ISO-8859-1");
//				parser.setEncoding("gb2312");
			}
			

			// 2.1、自定义一个Filter，用于过滤<Frame >标签，然后取得标签中的src属性值
			NodeFilter frameNodeFilter = new NodeFilter() {
				public boolean accept(Node node) {
					if (node.getText().startsWith("frame src=")) {
						return true;
					} else {
						return false;
					}
				}
			};
			
			//2.2、创建第二个Filter，过滤<a>标签
			NodeFilter aNodeFilter = new NodeClassFilter(LinkTag.class);
			
			//2.3、净土上述2个Filter形成一个组合逻辑Filter。
			OrFilter linkFilter = new OrFilter(frameNodeFilter, aNodeFilter);
			
			//3、使用parser根据filter来取得所有符合条件的节点
			NodeList nodeList = parser.extractAllNodesThatMatch(linkFilter);
			
			//4、对取得的Node进行处理
			for(int i = 0; i<nodeList.size();i++){
				Node node = nodeList.elementAt(i);
				String linkURL = "";
				//如果链接类型为<a />
				if(node instanceof LinkTag){
					LinkTag link = (LinkTag)node;
					linkURL= link.getLink();
				}else{
					//如果类型为<frame />
					String nodeText = node.getText();
					int beginPosition = nodeText.indexOf("src=");
					nodeText = nodeText.substring(beginPosition);
					int endPosition = nodeText.indexOf(" ");
					if(endPosition == -1){
						endPosition = nodeText.indexOf(">");
					}
					linkURL = nodeText.substring(5, endPosition - 1);
				}
				//判断是否属于本次搜索范围的url
				if(filter.accept(linkURL)){
					links.add(linkURL);
				}
			}
			
		} catch (ParserException e) {
			e.printStackTrace();
		}
		return links;
	}
	//测试的 main 方法
		public static void main(String[]args)
		{
	Set<String> links = HtmlParserTool.extractLinks("http://www.twt.edu.cn",new LinkFilter()
			{
				//提取以 http://www.twt.edu.cn 开头的链接
				public boolean accept(String url) {
					if(url.startsWith("http://www.twt.edu.cn"))
						return true;
					else
						return false;
				}
				
			},null);
			for(String link : links)
				System.out.println(link);
		}
}
