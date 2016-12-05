package xmlDev;
import java.io.File;
import java.util.List;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Dom4jRead {

	public static void main(String[] args) {
		SAXReader reader=new SAXReader();
		try {
			Document doc=reader.read(new File("student1_dom4j.xml"));
			Element root=doc.getRootElement();
			parse(root);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void parse(Element ele) {
		parseAttribute(ele);
		List<Element> el=ele.elements();
			for (Object e:el) {
				Element element=(Element) e;
				if (!element.isTextOnly()) {
					parse(element);
				}
				else {
					parseAttribute(element);
					if (element.getQName().getName().toString().equals("姓名")) {
						System.out.println(element.getQName().getName()+"--->"+element.getText());
					}
				}
			}
		
	}

	private static void parseAttribute(Element ele) {
		List attList=ele.attributes();
		for (Object e:attList) {
			Attribute attr=(Attribute) e;
			if (attr.getQName().getName().toString().equals("年级")) {
				System.out.println(ele.getQName().getName()+"元素的"
						+attr.getQName().getName()+"属性值为:"
						+attr.getValue());
			}
			
		}
	}

}
