package test1;


import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

public class JdomRead {

	public static void main(String[] args) {
		JdomRead test=new JdomRead();
		test.parseXml(new File("student.xml"));
	}

	//对student.xml进行解析并输出第2个学生元素的信息
	private void parseXml(File xmlFile) {
		SAXBuilder sax=new SAXBuilder();
		try {
			Document xmlDom=sax.build(xmlFile);
			Element root=xmlDom.getRootElement();
			System.out.println("根元素是"+ root.getName());
			
			//获取子元素
			List childList=root.getChildren();
			Iterator listIt= childList.iterator();
			
			while (listIt.hasNext()) {
				Element element=(Element) listIt.next();
				System.out.println("孩子节点是："+ element.getName());
			}
			
			//获取第二个孩子节点
			Element firstChild=(Element) childList.get(1);
			int k=0;
			List attrList=firstChild.getAttributes();
			Iterator attrIt=attrList.iterator();
			while (attrIt.hasNext()) {
				Attribute attr=(Attribute) attrIt.next();
				k=k+1;
				System.out.println("第二个元素的第"+k +"个属性是:"+attr.getName());
				System.out.println("属性值是:"+attr.getValue());
				System.out.println("属性类型是"+attr.getAttributeType());
			}
		
			//获取所有的元素并输出
			List sonList=firstChild.getChildren();
			Iterator sonIt=sonList.iterator();
			while (sonIt.hasNext()) {
				Element temp=(Element) sonIt.next();
				System.out.println("子元素"+temp.getName()+"的值是"+temp.getValue());
			}
		} catch (Exception e) {
		
		}
	}

}
