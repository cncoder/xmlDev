import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.*;
public class XmlDom4J{
	public void generateDocument(){
	Document document = DocumentHelper.createDocument();
	     Element root = document.addElement("ѧ������");
	     root.addComment("ʹ�ø��ӷ���ķ�ʽ����xml");
	   //������Ӵ���ָ�� root.addProcessingInstruction("target","text");
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
	     //���dtd˵�� document.addDocType("catalog",null,"file://c:/Dtds/catalog.dtd");
	    try{
	    OutputFormat format=new OutputFormat("    ", true,"GBK");
	    XMLWriter output = new XMLWriter(
	            new FileWriter( new File("student2_dom4j_with_DocumentHelper.xml") ),format);
	        output.write( document );
	        output.close();
	        }
	     catch(IOException e){System.out.println(e.getMessage());}
	}
	
	public static void main(String[] argv){
		XmlDom4J dom4j=new XmlDom4J();
		dom4j.generateDocument();
	}
}