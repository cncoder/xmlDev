package xmlDev;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class Traversal {

	public static void main(String[] args) {
		
		try {
			DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
			DocumentBuilder builder;
			builder = factory.newDocumentBuilder();
			try {
				Document document=builder.parse("xmlfile/students.xml");
				document.normalize();
				Element root=document.getDocumentElement();
				if(document!=null)
					printNode(root);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private static void printNode(Element element) {
		// 获取子节点和属性节点
		NodeList children=element.getChildNodes();
		NamedNodeMap attr=element.getAttributes();
		
		int r=children.getLength();
		if(attr!=null){
			System.out.print("<"+element.getNodeName());
			for(int j=0;j<attr.getLength();j++){
				System.out.print("  "+attr.item(j).getNodeName()+"="+attr.item(j).getNodeValue()+"  ");
			}
			System.out.println(">");
		}
		else if (attr==null) {
			System.out.println("<"+element.getNodeName()+">");
		}
		if (element.hasChildNodes()) {
			for (int k = 0; k < r; k++) {
				if (children.item(k).getNodeType()==Node.ELEMENT_NODE) {
					printNode((Element)children.item(k));
				}
				else if (children.item(k).getNodeType()==Node.TEXT_NODE) {
					System.out.println(children.item(k).getNodeValue());
				}
			}
			System.out.println("<"+element.getNodeName()+">");
		}
		
	}

}
