package xmlDev;

import java.io.FileOutputStream;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class Jdomtest1 {

	public static void main(String[] args) {
		System.out.println("��ʼ����xml�ļ�");
		Jdomtest1.BuildXML();
	}

	private static void BuildXML() {
		Element root;
		Element student;
		Element name;
		Element sex;
		Element age;
		Element birth;
		
		root=new Element("ѧ������");
		Attribute schoolname=new Attribute("ѧУ����", "���ݴ�ѧ�������ѧԺ");
		root.setAttribute(schoolname);
		
		student=new Element("ѧ��");
		Attribute grade=new Attribute("�꼶", "14��");
		Attribute number=new Attribute("ѧ��", "144******");
		
		student.setAttribute(grade);
		student.setAttribute(number);
		root.addContent(student);
		
		Document doc=new Document(root);
		
		name=new Element("����");
		sex=new Element("�Ա�");
		age=new Element("����");
		birth=new Element("����");
		
		name.setText("лXX");
		sex.setText("��");
		age.setText("22");
		birth.setText("1994-10-1");
		
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
			System.out.println("�����ļ�student.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
