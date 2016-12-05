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
		// ����ds.XML�ļ�
		File xmlFile = new File("xmlfile/ds.xml");
		//�����ļ�
		if(!xmlFile.exists()){
			try {
				xmlFile.createNewFile();
				System.out.println("�����ļ��ɹ�");
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
				Comment comment=doc.createComment("����XML�ļ�");
				doc.appendChild(comment);
				Element root=doc.createElement("�༶");
				Element stu=doc.createElement("ѧ��");
				Element name=doc.createElement("����");
				name.appendChild(doc.createTextNode("����"));
				Element sex =doc.createElement("�Ա�");
				sex.setAttribute("name", "��");
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
				// ����ʧ��
				e.printStackTrace();
			}		
		}
		

	private static void InsertXML() throws Exception, IOException {
		// �����Ӧ����
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		//factory.setIgnoringElementContentWhitespace(true);
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc=builder.parse("xmlfile/ds.xml");
			Element stu=doc.createElement("ѧ��");
			Element name=doc.createElement("����");
			name.appendChild(doc.createTextNode("����"));
			Element sex =doc.createElement("�Ա�");
			sex.setAttribute("name", "Ů");
			
			Comment comment=doc.createComment("���������");
			stu.appendChild(comment);
			stu.appendChild(name);
			stu.appendChild(sex);
			
			doc.getDocumentElement().insertBefore(stu, doc.getElementsByTagName("ѧ��").item(0));
			
			TransformerFactory factory1= TransformerFactory.newInstance();
			Transformer tformer= factory1.newTransformer();
			tformer.transform(new DOMSource(doc), new StreamResult("xmlfile/ds.xml"));
			
		} catch (ParserConfigurationException e) {
			// ����ʧ��
			e.printStackTrace();
		}		
		
	}

}
