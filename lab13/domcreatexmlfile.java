import java.io.FileWriter;
import java.io.IOException;
import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;


public class domcreatexmlfile {
/*
 * ����XML file
 */
	public static void createxml() throws IOException{
	DocumentFactory factory=new DocumentFactory();
	Document doc=factory.createDocument();
	Element root=doc.addElement("ѧ������");
	root.addAttribute("ѧУ", "���ݴ�ѧ�������ѧԺ");
	Element stuElement=root.addElement("ѧ��");
	stuElement.addAttribute("�꼶", "14��");
	stuElement.addAttribute("ѧ��", "14098765");
	Element name=stuElement.addElement("����");
	name.setText("����");
	Element sex=stuElement.addElement("�Ա�");
	sex.setText("Ů");
	Element age=stuElement.addElement("����");
	age.setText("18");
	Element bir=stuElement.addElement("����");
	bir.setText("2010-08-08");
	
	OutputFormat format=new OutputFormat("    ", true,"GBK");
	FileWriter fw=new FileWriter("student2_dom4j.xml");
	XMLWriter xmlWriter=new XMLWriter(fw,format);
	xmlWriter.write(doc);
	System.out.println(doc.toString());
	
	//xmlWriter.flush();
	xmlWriter.close();
 }
	public static void main(String[] args) {
		try {
			createxml();
			System.out.println("�ĵ������ɹ�");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
