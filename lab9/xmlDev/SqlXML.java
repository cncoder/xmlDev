package xmlDev;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class SqlXML {

	public static void main(String[] args) throws IOException, Exception {
		CreateXml();
		InsertXML();
	}

	private static void CreateXml() {
		// 创建ds.XML文件
		File xmlFile = new File("xmlfile/ds.xml");
		//创建文件
		if(!xmlFile.exists()){
			try {
				xmlFile.createNewFile();
				System.out.println("创建文件成功");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
			DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
			factory.setIgnoringElementContentWhitespace(true);
			try {
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document doc=builder.newDocument();
				doc.setXmlVersion("1.0");
				Comment comment=doc.createComment("创建XML文件");
				doc.appendChild(comment);
				Element root=doc.createElement("班级");
				Element stu=doc.createElement("学生");
				Element name=doc.createElement("姓名");
				name.appendChild(doc.createTextNode("张三"));
				Element sex =doc.createElement("性别");
				sex.setAttribute("name", "男");
				stu.appendChild(name);
				stu.appendChild(sex);
				root.appendChild(stu);
				doc.appendChild(root);
				
				TransformerFactory factory1 =TransformerFactory.newInstance();
				Transformer tformer;
				try {
					tformer = factory1.newTransformer();
					try {
						tformer.transform(new DOMSource(doc), new StreamResult("xmlfile/ds.xml"));
					} catch (TransformerException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (TransformerConfigurationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			} catch (ParserConfigurationException e) {
				// 创建失败
				e.printStackTrace();
			}		
		}
		

	private static void InsertXML() throws Exception, IOException {
		// 插入对应数据
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		//factory.setIgnoringElementContentWhitespace(true);
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc=builder.parse("xmlfile/ds.xml");
			Element stu=doc.createElement("学生");
			Element name=doc.createElement("姓名");
			name.appendChild(doc.createTextNode("李四"));
			Element sex =doc.createElement("性别");
			sex.setAttribute("name", "女");
			
			Comment comment=doc.createComment("插入的内容");
			stu.appendChild(comment);
			stu.appendChild(name);
			stu.appendChild(sex);
			
			doc.getDocumentElement().insertBefore(stu, doc.getElementsByTagName("学生").item(0));
			
			TransformerFactory factory1= TransformerFactory.newInstance();
			Transformer tformer= factory1.newTransformer();
			tformer.transform(new DOMSource(doc), new StreamResult("xmlfile/ds.xml"));
			
		} catch (ParserConfigurationException e) {
			// 创建失败
			e.printStackTrace();
		}		
		
	}

}
