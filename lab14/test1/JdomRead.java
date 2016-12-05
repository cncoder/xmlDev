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

	//��student.xml���н����������2��ѧ��Ԫ�ص���Ϣ
	private void parseXml(File xmlFile) {
		SAXBuilder sax=new SAXBuilder();
		try {
			Document xmlDom=sax.build(xmlFile);
			Element root=xmlDom.getRootElement();
			System.out.println("��Ԫ����"+ root.getName());
			
			//��ȡ��Ԫ��
			List childList=root.getChildren();
			Iterator listIt= childList.iterator();
			
			while (listIt.hasNext()) {
				Element element=(Element) listIt.next();
				System.out.println("���ӽڵ��ǣ�"+ element.getName());
			}
			
			//��ȡ�ڶ������ӽڵ�
			Element firstChild=(Element) childList.get(1);
			int k=0;
			List attrList=firstChild.getAttributes();
			Iterator attrIt=attrList.iterator();
			while (attrIt.hasNext()) {
				Attribute attr=(Attribute) attrIt.next();
				k=k+1;
				System.out.println("�ڶ���Ԫ�صĵ�"+k +"��������:"+attr.getName());
				System.out.println("����ֵ��:"+attr.getValue());
				System.out.println("����������"+attr.getAttributeType());
			}
		
			//��ȡ���е�Ԫ�ز����
			List sonList=firstChild.getChildren();
			Iterator sonIt=sonList.iterator();
			while (sonIt.hasNext()) {
				Element temp=(Element) sonIt.next();
				System.out.println("��Ԫ��"+temp.getName()+"��ֵ��"+temp.getValue());
			}
		} catch (Exception e) {
		
		}
	}

}
