package api;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.AndFilter;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.filters.OrFilter;
import org.htmlparser.tags.TableRow;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

import com.sun.tools.javac.util.List;

//本类创建用于HTML文件解释工具
public class HtmlParserToolDTB {

	// 本方法用于提取某个html文档中内嵌的链接
	public static ArrayList<RHAccount> extractLinks(String url, LinkFilter filter ,String charset) {
		ArrayList<RHAccount> tAccountList = new ArrayList<RHAccount>();
		try {
			// 1、构造一个Parser，并设置相关的属性
			Parser parser = new Parser(url);
			if(charset!=null){
				parser.setEncoding(charset);
			}else{
				parser.setEncoding("UTF-8");
			}
			

			NodeFilter aNodeFilter = new NodeClassFilter(TableRow.class){
				public boolean accept(Node node) {
					if (node.getText().contains("table_b datatable ")) {
						return true;
					} else {
						return false;
					}
				}
			};
			
			//3、使用parser根据filter来取得所有符合条件的节点
			NodeList nodeList = parser.extractAllNodesThatMatch(aNodeFilter);
			
			//4、对取得的Node进行处理
			for(int i = 0; i<nodeList.size();i++){
				
				Node node = nodeList.elementAt(i);
				String nodeText = node.getText();
				int beginPosition = nodeText.indexOf("CustomeShow.aspx?");
				nodeText = nodeText.substring(beginPosition+16);
				String idString = nodeText.substring(beginPosition, 6);
				long id = Long.parseLong(idString);
				String docid = nodeText.substring(beginPosition, 6);
				RHAccount rHAccount = new RHAccount();
				rHAccount.setId(id);
				rHAccount.setDocid(docid);
				tAccountList.add(rHAccount);
				}
			
		} catch (ParserException e) {
			e.printStackTrace();
		}
		return tAccountList;
	}
	//测试的 main 方法
		public static void main(String[]args)
		{
		}
}
