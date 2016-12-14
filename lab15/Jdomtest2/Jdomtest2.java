package Jdomtest2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class Jdomtest2 {

	public static void main(String[] args) {
		SAXBuilder builder=new SAXBuilder();
		
		try {
			Document doc=builder.build(new File("student.xml"));
			System.out.println("�ļ����سɹ�");
			
			Element root=doc.getRootElement();
			Element student=new Element("ѧ��");
			Attribute grade=new Attribute("�꼶", "14��");
			Attribute number=new Attribute("ѧ��", "1440121205");
			
			student.setAttribute(grade);
			student.setAttribute(number);
			root.addContent(student);
			
			
			
			Element name=new Element("����");
			Element sex=new Element("�Ա�");
			Element age=new Element("����");
			Element birth=new Element("����");
			
			name.setText("����");
			sex.setText("��");
			age.setText("20");
			birth.setText("1991-10-1");
			
			student.addContent(name);
			student.addContent(sex);
			student.addContent(age);
			student.addContent(birth);
			
			Format format=Format.getCompactFormat();
			format.setEncoding("gb2312");
			format.setIndent("    ");
			
			XMLOutputter xmlout=new XMLOutputter(format);
			try {
				xmlout.output(doc, new FileOutputStream("student.xml"));
				System.out.println("�ɹ��޸�student.xml");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (JDOMException e) {
			System.out.println("�ļ�����ʧ��");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("�ļ�����ʧ��");
			e.printStackTrace();
		}
	}

}
